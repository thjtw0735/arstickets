package com.tonmedia.tickets.service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tonmedia.tickets.domain.Match;
import com.tonmedia.tickets.domain.Shipping;
import com.tonmedia.tickets.domain.Ticket;
import com.tonmedia.tickets.domain.User;

@Service
public class ReservationService {

	@Autowired
	com.tonmedia.tickets.mapper.ReservationMapper ReservationMapper;
	
	@Autowired
	com.tonmedia.tickets.mapper.MatchMapper MatchMapper;
	
	@Autowired
	com.tonmedia.tickets.mapper.UserMapper UserMapper;
	
	@Autowired
	com.tonmedia.tickets.mapper.ShippingMapper ShippingMapper;

	// ó�� �������� ���� �� or ������� �������� �Ѿ �� or ������� ���������� �����ܰ�� �̵�  �� ������ ����� ��(resvcheck�� ������ ���� ���� ������� �������� �Ѿ ��)
	public String view(Model model, HttpServletRequest request, Match match, Ticket ticket, User user ) {
		// resvcheck : �¼� insert �Ϸ� �� �������� Ȯ�� �������� resvcheck�� �Ѿ�� ���
		String resvcheck = request.getParameter("resvcheck");
		String homeimage = request.getParameter("homeimage");
		String awayimage = "https://www.arsenal.com" + request.getParameter("awayimage");
		String home = request.getParameter("home");
		String away = request.getParameter("away");
		String date = request.getParameter("date");
		String stadium = request.getParameter("stadium");
		match.setMatch_date(date);
		match.setMatch_home(home);
		match.setMatch_away(away);
		match.setMatch_himage(homeimage);
		match.setMatch_aimage(awayimage);
		match.setMatch_stadium(stadium);

		// ��������Է� �������� �Ѿ�� �κ�
		if(resvcheck != null ){
			String time = "";
			time = (String) request.getSession().getAttribute("time");
			
			// �ð����� ���ǿ� ���� ���� ���� ���
			if(time == null ){
				Date datetime = new Date();
				SimpleDateFormat timeform = new SimpleDateFormat("HHmm"); 
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(datetime);
				cal.add(Calendar.MINUTE, 1);
				time = timeform.format(cal.getTime());
				request.getSession().setAttribute("time", time);
			} else {
				time = (String)request.getSession().getAttribute("time");
			}
			  
	/*		String time = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());
			System.out.println("����ð� : " + time);*/
			
			String checkdate = request.getParameter("date");
			String level = request.getParameter("level");
			int price = Integer.parseInt(request.getParameter("price"));
			
			// �¼� ���� �ѱ�� 
			String seat = request.getParameter("seat");
			String[] st = seat.split(",");
			match.setMatch_date(checkdate);
			// ��¥������ �ش� ��ġ ���� ��������
			List <Match> matchlist  = this.MatchMapper.selectMatch(match);
			int ticketcount = st.length;
			int ticketprice = ticketcount * price;
			int vat = (int) (ticketprice * 0.1);
			int totalprice = ticketprice + vat;
			
			
			//���� �α������� ������ ���� ��������
			String semail = (String) request.getSession().getAttribute("email");
			user.setEmail(semail);
			user = this.UserMapper.select(user);
			model.addAttribute("match", matchlist);
			model.addAttribute("user", user);
			model.addAttribute("seat", seat);
			model.addAttribute("level", level);
			model.addAttribute("st", st);
			model.addAttribute("ticketprice", ticketprice);
			model.addAttribute("totalprice", totalprice);
			model.addAttribute("vat", vat);
			model.addAttribute("time", time);
				return "resvcheck";
		
		} else {
			// ù �����ϱ� �������� ������ �κ�
			// reservation ��ư ������ match ������� �Է�. match ��ȣ�� ���ؼ� ���� �� ���� ���� �ִ� ������.
			int result = this.MatchMapper.selectDate(match);
			if (result == 0){
				this.MatchMapper.insert(match);
			}
			
			
			//reservation ù��° â view���� ��ġ ���� �ѷ��ִ� select
			List <Match> matchlist  = this.MatchMapper.selectMatch(match);
			int match_num = matchlist.get(0).getMatch_num();
			ticket.setMatch_num(match_num);
			
			// �����ܰ�� �̵� �� �����ߴ� �ڸ� ���� 
			String seatdelete = request.getParameter("seat");
			String level = request.getParameter("level");
			ticket.setTicket_level(level);
			if( seatdelete != null ){
				String[] st = seatdelete.split(",");
				for( int i=0; i<st.length; i++){
					ticket.setTicket_seatnum(st[i]);
					this.ReservationMapper.delete(ticket);
				}	
			}
			
			request.getSession().removeAttribute("time");
			
	
			
			//reservation ù��° â view���� ��ġ ���� �ѷ��ִ� select
			ticket.setTicket_level("W");
			List<Ticket> wsection = this.ReservationMapper.list(ticket);
			String wsize = Integer.toString(100 - wsection.size());
			
			ticket.setTicket_level("S");
			List<Ticket> ssection = this.ReservationMapper.list(ticket);
			String ssize = Integer.toString(100 - ssection.size());
			
			ticket.setTicket_level("E");
			List<Ticket> esection = this.ReservationMapper.list(ticket);
			String esize = Integer.toString(100 - esection.size());
			
			ticket.setTicket_level("N");
			List<Ticket> nsection = this.ReservationMapper.list(ticket);
			String nsize = Integer.toString(100 - nsection.size());
			
			
			model.addAttribute("wsection", wsize);
			model.addAttribute("esection", esize);
			model.addAttribute("ssection", ssize);
			model.addAttribute("nsection", nsize);
			model.addAttribute("match", matchlist);
			return "view";
		}
	}
	
	// �¼����� �� NEXT ��ư�� ���� �����ܰ�� �Ѿ��  ���� ticket db�� insert
	public int insertSeat( Model model, Ticket ticket, HttpServletRequest request, Match match ) {
		String level = request.getParameter("level");
		String seat = request.getParameter("seat");
		String ind = request.getParameter("ind");
		String date = request.getParameter("date");
		int price = Integer.parseInt(request.getParameter("price"));
		
		// �߶� ������
		String[] st = seat.split(",");
		String[] in = ind.split(",");
		
		int result = 0;
		match.setMatch_date(date);
		// ��¥�� ������ match_num�� ticket match_num�� �μ�Ʈ
		List <Match> matchlist  = this.MatchMapper.selectMatch(match);
		int match_num = matchlist.get(0).getMatch_num();
		ticket.setMatch_num(match_num);
		ticket.setTicket_level(level);
		ticket.setTicket_price(price);
		
		
		// �ڸ� �̹� �������� alredy reserved ���� ����
		for( int i=0; i<st.length; i++){
			ticket.setTicket_seatnum(st[i]);
			result = this.ReservationMapper.select(ticket);
			if ( result == 1 ){
				return result;
			}
		}
		
		// ticket�� �¼����� �ϳ��ϳ����� db�� insert
		for( int i=0; i<st.length; i++){
			ticket.setTicket_seatnum(st[i]);
			ticket.setTicket_index(in[i]);
			this.ReservationMapper.insert(ticket);
		}
		
		return result;
	}

	// ���� ���� �� �ش� ���� seat���� �ҷ�����
	public Object seatselect(Model model, HttpServletRequest request, Match match, Ticket ticket) {
		String level = request.getParameter("level");
		String date = request.getParameter("date");
		match.setMatch_date(date);

		//��ġ��ȣ�� ��Ī�Ǵ� Ƽ�����̺� ���� ��������
		List <Match> matchlist  = this.MatchMapper.selectMatch(match);
		int match_num = matchlist.get(0).getMatch_num();
		ticket.setMatch_num(match_num);
		ticket.setTicket_level(level);
		List<Ticket> seats = this.ReservationMapper.list(ticket);
		List<String> ticketIndex  = new ArrayList<String>();
		for( int i=0; i<seats.size(); i++){
			ticketIndex.add(seats.get(i).getTicket_index());
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "OK");
		result.put("ticketIndex", ticketIndex);
		
		return result;
	}

	// �ֹ��� ������ ������ ���
	public Object userselect(HttpServletRequest request, User user) {
		
		// ������� ���������� ���� ������ ���� �������� ��� ���� �Է� �� 
		String sessionId = (String)request.getSession().getAttribute("email");
		user.setEmail(sessionId);
		user = this.UserMapper.select(user);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "OK");
		result.put("user", user);
		
		return result;
	}

	// �ð��ʰ��� ���� �¼����� delete
	public Object seatDelete(Model model, HttpServletRequest request, Ticket ticket, Match match, Shipping shipping) {
		String seat= request.getParameter("seat");
		String level = request.getParameter("level");
		String dates = request.getParameter("dates");
		int match_num = 0;
		
		if( dates != null ){
			//�������������� �ش��¼� ���� ��
			
			// ���Ź�ȣ�� ���Ż��� '��ҿϷ�'�� ������Ʈ
			int rvnum = Integer.parseInt(request.getParameter("rvnum"));
			shipping.setShipping_num(rvnum);
			String cancel = "��ҿϷ�";
			shipping.setShipping_status(cancel);
			this.ShippingMapper.update(shipping);
			
			
			String seats = request.getParameter("seats");
			match.setMatch_date(dates);
			List <Match> matchlist  = this.MatchMapper.selectMatch(match);
			match_num = matchlist.get(0).getMatch_num();
			level = seats.substring(0,1);
			seat = seats.substring(5);
			ticket.setMatch_num(match_num);
			ticket.setTicket_level(level);
			
		} else {
			//�ð��ʰ��� �ش��¼� ���� ��
			match_num = Integer.parseInt(request.getParameter("match_num"));
			ticket.setMatch_num(match_num);
			ticket.setTicket_level(level);
		}
		
		String[] st = seat.split(",");
		for( int i=0; i<st.length; i++){
			ticket.setTicket_seatnum(st[i]);
			this.ReservationMapper.delete(ticket);
		}	
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "OK");
		return result;
	}
	
	
}






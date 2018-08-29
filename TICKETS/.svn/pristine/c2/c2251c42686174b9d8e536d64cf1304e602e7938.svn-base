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

	// 처음 뷰페이지 들어올 때 or 배송정보 페이지로 넘어갈 때 or 배송정보 페이지에서 이전단계로 이동  총 세번의 경우의 수(resvcheck값 가지고 들어올 때가 배송정보 페이지로 넘어갈 때)
	public String view(Model model, HttpServletRequest request, Match match, Ticket ticket, User user ) {
		// resvcheck : 좌석 insert 완료 후 예매정보 확인 페이지인 resvcheck로 넘어갈때 사용
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

		// 배송정보입력 페이지로 넘어가는 부분
		if(resvcheck != null ){
			String time = "";
			time = (String) request.getSession().getAttribute("time");
			
			// 시간정보 세션에 있을 경우와 없을 경우
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
			System.out.println("현재시각 : " + time);*/
			
			String checkdate = request.getParameter("date");
			String level = request.getParameter("level");
			int price = Integer.parseInt(request.getParameter("price"));
			
			// 좌석 정보 넘기기 
			String seat = request.getParameter("seat");
			String[] st = seat.split(",");
			match.setMatch_date(checkdate);
			// 날짜값으로 해당 매치 정보 가져오기
			List <Match> matchlist  = this.MatchMapper.selectMatch(match);
			int ticketcount = st.length;
			int ticketprice = ticketcount * price;
			int vat = (int) (ticketprice * 0.1);
			int totalprice = ticketprice + vat;
			
			
			//현재 로그인중인 유저의 정보 가져오기
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
			// 첫 예매하기 페이지로 들어오는 부분
			// reservation 버튼 눌러서 match 디비정보 입력. match 번호로 비교해서 같은 거 없을 때만 넣는 것으로.
			int result = this.MatchMapper.selectDate(match);
			if (result == 0){
				this.MatchMapper.insert(match);
			}
			
			
			//reservation 첫번째 창 view에서 매치 정보 뿌려주는 select
			List <Match> matchlist  = this.MatchMapper.selectMatch(match);
			int match_num = matchlist.get(0).getMatch_num();
			ticket.setMatch_num(match_num);
			
			// 이전단계로 이동 시 선택했던 자리 삭제 
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
			
	
			
			//reservation 첫번째 창 view에서 매치 정보 뿌려주는 select
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
	
	// 좌석선택 후 NEXT 버튼을 눌러 다음단계로 넘어갈때  정보 ticket db에 insert
	public int insertSeat( Model model, Ticket ticket, HttpServletRequest request, Match match ) {
		String level = request.getParameter("level");
		String seat = request.getParameter("seat");
		String ind = request.getParameter("ind");
		String date = request.getParameter("date");
		int price = Integer.parseInt(request.getParameter("price"));
		
		// 잘라서 넣을때
		String[] st = seat.split(",");
		String[] in = ind.split(",");
		
		int result = 0;
		match.setMatch_date(date);
		// 날짜로 가져온 match_num을 ticket match_num에 인서트
		List <Match> matchlist  = this.MatchMapper.selectMatch(match);
		int match_num = matchlist.get(0).getMatch_num();
		ticket.setMatch_num(match_num);
		ticket.setTicket_level(level);
		ticket.setTicket_price(price);
		
		
		// 자리 이미 차있으면 alredy reserved 띄우는 구간
		for( int i=0; i<st.length; i++){
			ticket.setTicket_seatnum(st[i]);
			result = this.ReservationMapper.select(ticket);
			if ( result == 1 ){
				return result;
			}
		}
		
		// ticket에 좌석정보 하나하나마다 db에 insert
		for( int i=0; i<st.length; i++){
			ticket.setTicket_seatnum(st[i]);
			ticket.setTicket_index(in[i]);
			this.ReservationMapper.insert(ticket);
		}
		
		return result;
	}

	// 구역 선택 시 해당 구역 seat정보 불러오기
	public Object seatselect(Model model, HttpServletRequest request, Match match, Ticket ticket) {
		String level = request.getParameter("level");
		String date = request.getParameter("date");
		match.setMatch_date(date);

		//매치번호로 매칭되는 티켓테이블 정보 가져오기
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

	// 주문자 정보와 동일할 경우
	public Object userselect(HttpServletRequest request, User user) {
		
		// 배송정보 페이지에서 유저 정보와 같은 내용으로 배송 정보 입력 시 
		String sessionId = (String)request.getSession().getAttribute("email");
		user.setEmail(sessionId);
		user = this.UserMapper.select(user);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "OK");
		result.put("user", user);
		
		return result;
	}

	// 시간초과로 인해 좌석정보 delete
	public Object seatDelete(Model model, HttpServletRequest request, Ticket ticket, Match match, Shipping shipping) {
		String seat= request.getParameter("seat");
		String level = request.getParameter("level");
		String dates = request.getParameter("dates");
		int match_num = 0;
		
		if( dates != null ){
			//마이페이지에서 해당좌석 삭제 시
			
			// 예매번호로 예매상태 '취소완료'로 업데이트
			int rvnum = Integer.parseInt(request.getParameter("rvnum"));
			shipping.setShipping_num(rvnum);
			String cancel = "취소완료";
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
			//시간초과로 해당좌석 삭제 시
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






package com.tonmedia.tickets.service;

import java.text.DateFormat;
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
import com.tonmedia.tickets.domain.TimeCheck;
import com.tonmedia.tickets.mapper.ShippingMapper;

//jsoup


@Service
public class MypageService {
	
	@Autowired
	ShippingMapper shippingMapper;
	
	@Autowired
	com.tonmedia.tickets.mapper.TimeCheckMapper TimeCheckMapper;
	
	// 마이페이지 view
	public String main( Model model, HttpServletRequest request, Shipping shipping, Match match ){
		
		String email = (String) request.getSession().getAttribute("email");
		shipping.setEmail(email);
		String date = request.getParameter("date");
		int count = 0;
		String cdate = request.getParameter("cdate");
		
		if( cdate != null ) {
			shipping.setShipping_date(date);
			count = this.shippingMapper.getcountDate(shipping);
		} else {
			count = this.shippingMapper.getcount(shipping);
		}
		
		
		if(count == 0){
			String pageNum = null;
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("count",count);
			return "mypage";
		} else {
		
		// 페이징 처리
				int pageSize= 3;		// 한페이지에 출력할 글 개수
				int pageBlock = 3;		// 한 번에 보여줄 페이지 개수
		
					
				String pageNum = null;
				int currentPage =0;		// 현재 페이지
				int start = 0;			// 현재 페이지 시작번호
				int end = 0;			// 현재 페이지 끝번호
				int number = 0;			// 출력용 글번호 계산
				
				int pageCount = 0;		// 페이지 개수
				int startPage = 0;		// 보여줄 페이지의 시작 번호
				int endPage = 0;		// 보여줄 페이지의 끝 번호

				if ( cdate != null ){
					shipping.setShipping_date(date);
					count = this.shippingMapper.getcountDate(shipping);
				} else {
					count = this.shippingMapper.getcount(shipping);
				}
				System.out.println("카운트 : " + count );
				pageNum = request.getParameter( "pageNum" );
				if( pageNum == null || pageNum.equals("")) {
					pageNum = "1";
				}
					
				currentPage = Integer.parseInt( pageNum );
					pageCount = count / pageSize + (count % pageSize > 0 ? 1 : 0);
				if( currentPage > pageCount ) currentPage = pageCount;
					
				start = ( currentPage - 1 ) * pageSize + 1;	// (5 - 1) * 10 + 1 41
				end = start + pageSize - 1;					// 41 + 10 - 1 		50
				if( end > count ) end = count;
				
				number = count - ( currentPage- 1 ) * pageSize;	// 50 - ( 2-1 ) * 10
				
				if( count  > 0 ) {
					startPage = ( currentPage / pageBlock ) * pageBlock+ 1;
							//  (     15	  /	    10    ) * 10	   + 1;
					
					if( currentPage % pageBlock == 0 ) startPage -= pageBlock;
					endPage = startPage + pageBlock - 1;
							//		1   +    10     - 1		-> 20
					if(endPage > pageCount ) endPage = pageCount;
				}
				
				
				model.addAttribute("count",count);
				model.addAttribute("pageNum",pageNum);

				
				List<Shipping> shippinglist = new ArrayList<Shipping>();
				/*
				// 날짜 조회해서 뿌려주는 경우
				if( date != null ){
					shipping.setShipping_date(date);
					shippinglist = this.shippingMapper.selectDate(shipping);
				} else {
				// 전체 다 뿌려주는 경우
					shippinglist = this.shippingMapper.select(shipping);
				}*/
				
				
				
				if( count != 0){
					Map < String, Object > map = new HashMap<String, Object>();
					map.put("start", start );
					map.put("end", end);
					map.put("email", email);
					System.out.println("start : " + start );
					System.out.println("end : " + end );
					// 날짜 조회해서 뿌려주는 경우
					if( date != null ){
						map.put("date", date);
						shippinglist = this.shippingMapper.selectDate(map);
					} else {
					// 전체 다 뿌려주는 경우
						shippinglist = this.shippingMapper.select(map);
					}
					
					// 글이 있는 경우
					/*List<BoardDataBean> list = dao.getArticles( map );*/
					
					model.addAttribute("date", date);
					model.addAttribute("cdate", cdate);
					model.addAttribute("number", number);
					model.addAttribute("currentPage", currentPage);
					model.addAttribute("pageBlock", pageBlock);
					model.addAttribute("startPage", startPage);
					model.addAttribute("endPage", endPage);
					model.addAttribute("pageCount", pageCount);
				}
				
		List<Integer> matchnum = new ArrayList<Integer>();
		List<Match> matchlist = new ArrayList<Match>();
		for (int i=0; i<shippinglist.size(); i++ ){
			matchnum.add(shippinglist.get(i).getMatch_num());
		}
		for (int i=0; i< matchnum.size(); i++ ){
				int match_num = matchnum.get(i);
				matchlist.add(this.shippingMapper.selectMatch(match_num));
		}
		
		
		model.addAttribute("shippinglist", shippinglist);
		model.addAttribute("matchlist", matchlist);
		return "mypage";
		}
	}
	
	
	//배송정보 페이지에서 마이페이지로 넘어올 때 shipping table에 들어갈 배송 및 경기 정보 insert
	public Object shippinginsert(Model model, HttpServletRequest request, Shipping shipping, TimeCheck timeCheck ) {
		// shipping 테이블에 insert 할 값들 정리
		String email = (String) request.getSession().getAttribute("email");
		shipping.setEmail(email);
		shipping.setShipping_status("예매완료");
		String seat = request.getParameter("seat");
		String level = request.getParameter("level");
		String shipping_ticket = level + "석 " + seat;
		shipping.setShipping_ticket(shipping_ticket);
		
		
		Date datetime = new Date();
		SimpleDateFormat timeform = new SimpleDateFormat("HH:mm:ss"); 
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(datetime);
		String time = timeform.format(cal.getTime());
		timeCheck.setCheck_time(time);
		
		this.TimeCheckMapper.tran(timeCheck);
		

		//shipping 테이블에 insert할 매 수 
		String[] st = seat.split(",");
		int count = st.length;
		shipping.setShipping_count(count);
		
		//배송정보 및 마이페이지에 보여줘야할 내용 insert
		this.shippingMapper.insert(shipping);
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "OK");
		return result;
	}
	
	
}
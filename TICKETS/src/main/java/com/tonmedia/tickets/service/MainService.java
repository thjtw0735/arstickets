package com.tonmedia.tickets.service;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.tonmedia.tickets.domain.User;
import com.tonmedia.tickets.mapper.MainMapper;
import com.tonmedia.tickets.mapper.UserMapper;


@Service
public class MainService {

	@Autowired
	MainMapper monitoringMapper;
	
	@Autowired
	UserMapper userMapper;

	private final static String fixturesad = "https://www.arsenal.com/fixtures";
	private final static String newsad = "https://www.arsenal.com/news";

	// 메인페이지
	public String mainProc(/*@RequestParam(value="session", required=false)*/ String session, Model model, HttpServletRequest request, User user) throws Exception {
		
		/*String session = request.getParameter("session");*/
		if( session != null ){
			request.getSession().removeAttribute("email");
		}
		
		String email = (String)request.getSession().getAttribute("email");
		
		String imgAddr = "";
		if( email != null ){
			System.out.println(email);
			user.setEmail(email);
			imgAddr = this.userMapper.selectImg(email);
			System.out.println(imgAddr);
			
		}
		
		
		Document fixtures = Jsoup.connect(fixturesad).header("User-Agent", "Mozilla/5.0").get();
		Document news = Jsoup.connect(newsad).header("User-Agent", "Mozilla/5.0").get();
		
		
		//경기연도
		String year = fixtures.select("h2.accordion__title").eq(0).text();
		year = year.substring(year.length()-4, year.length());
		
		/*경기장*/
		String stadium1 = fixtures.select("div.event-info__venue").eq(1).text();
		String stadium2 = fixtures.select("div.event-info__venue").eq(2).text();
		
		/*시간 날짜*/
		String date1 = fixtures.select("time").eq(2).text();
		String date2 = fixtures.select("time").eq(5).text();
		
		/*팀이름*/
		String namehome = "Arsenal";
		String nameaway1 = fixtures.select("span.team-crest__name-value").eq(0).text();
		String nameaway2 = fixtures.select("span.team-crest__name-value").eq(1).text();
		
        /*팀로고*/
		Elements logo = fixtures.getElementsByTag("IMG");
		
		String logohome = "https://www.arsenal.com/sites/default/files/styles/feed_crest_thumbnail/public/logos/arsenal.png?itok=gaU3837L";
		String logoaway1 = logo.select("img.team-crest__crest").eq(2).attr("src");
		String logoaway2 = logo.select("img.team-crest__crest").eq(3).attr("src");
		
		/*뉴스링크	*/
		Elements newslink = fixtures.getElementsByTag("a");
		ArrayList<String> linklist = new ArrayList<String>();
		for(int i=0;i<newslink.size();i++)
        {
			if(newslink.get(i).attr("href").length() > 6 ){
				if (newslink.get(i).attr("href").substring(0,6).equals("/news/")){
							linklist.add(newslink.get(i).attr("href"));
					}
			}
        }
		
        /*뉴스제목*/
        String newstitle1 = news.select("a.link-list__link").eq(0).text();
		String newstitle2 = news.select("a.link-list__link").eq(1).text();
		String newstitle3 = news.select("a.link-list__link").eq(2).text();
		
		/*뉴스이미지*/
		Elements newsimg =news.getElementsByTag("div");
		ArrayList<String> imglist = new ArrayList();
        for(int i=0; i<newsimg.size(); i++)
        {
            if(newsimg.get(i).attr("data-src") != ""){
            	imglist.add(newsimg.get(i).attr("data-src"));
            }
        }
		
        ArrayList<String> ftlist = new ArrayList();
        
		ftlist.add( stadium1 );
		ftlist.add( stadium2 );
		ftlist.add( date1 );
		ftlist.add( date2 );
		ftlist.add( namehome );
		ftlist.add( nameaway1 );
		ftlist.add( nameaway2 );
		ftlist.add( logohome );
		ftlist.add( logoaway1 );
		ftlist.add( logoaway2 );
		ftlist.add( year);
        
		ArrayList<String> newslist = new ArrayList();
		newslist.add(newstitle1);
		newslist.add(newstitle2);
		newslist.add(newstitle3);
		
		model.addAttribute("ftlist", ftlist );
		model.addAttribute("newslist", newslist );
		model.addAttribute("imglist", imglist );
		model.addAttribute("linklist", linklist );
		model.addAttribute("imgAddr", imgAddr);
		
		return "main";
	}		
}
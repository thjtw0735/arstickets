/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.82
 * Generated at: 2018-07-20 07:27:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class resvcheck_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"http://dmaps.daum.net/map_js_init/postcode.v2.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/css/resvcheck.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background:#e9eef7;\">\r\n");
      out.write("\t<div class=\"contents_wrap\">\r\n");
      out.write("\t\t<div class=\"top_menu\">\r\n");
      out.write("\t\t\t<div class=\"seat_level\">등급/좌석선택</div>\r\n");
      out.write("\t\t\t<div class=\"ticket_check\">배송선택/매수확인/결제</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"contents\" style=\"background: #f00000;\">\r\n");
      out.write("\t\t\t<div class=\"contents_top\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.get(0).match_himage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"image\"><input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.get(0).match_home}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("     VS     ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.get(0).match_away}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"home\" readonly><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.get(0).match_aimage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"image\" readonly> <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.get(0).match_stadium}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"detail\" readonly> <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.get(0).match_date}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"detail\" id=\"date\" readonly>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"contents_left\">\r\n");
      out.write("\t\t\t<form id=\"shippingForm\">\r\n");
      out.write("\t\t\t\t<table class=\"table_left\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\" style=\"color:red;font-weight:bold;font-size:17px;\"> 5분이내 결제하시면 예매가 완료 됩니다.</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\" class=\"rvuser\" style=\"font-weight:bold;\">주문자 확인</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr class=\"truser\">\r\n");
      out.write("\t\t\t\t\t\t<td>이름</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr class=\"truser\">\r\n");
      out.write("\t\t\t\t\t\t<td>휴대폰 번호</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.phone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr class=\"truser\">\r\n");
      out.write("\t\t\t\t\t\t<td>주소</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\" class=\"rvuser\" style=\"font-weight:bold;\">배송정보                <input type=\"checkbox\" id=\"chbox\" >주문자 정보와 동일</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr class=\"truser\">\r\n");
      out.write("\t\t\t\t\t\t<td>이름</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" id=\"shipping_name\" name=\"shipping_name\" class=\"delivery\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr class=\"truser\">\r\n");
      out.write("\t\t\t\t\t\t<td>휴대폰 번호</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" id=\"shipping_phone\" name=\"shipping_phone\"  class=\"delivery\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr class=\"truser\">\r\n");
      out.write("\t\t\t\t\t\t<td>주소</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" id=\"shipping_address\" name=\"shipping_address\"  class=\"delivery\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"match_num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.get(0).match_num}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"seat\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seat}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"level\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${level}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t   \t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<button onclick=\"setaddress()\" class=\"findad\">우편번호찾기</button>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"contents_right\">\r\n");
      out.write("\t\t  \t\t<table border=\"0\" class=\"table_right\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\" class=\"rvheight\" style=\"border-top-color : red;\">예매정보</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"/>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr class=\"prheight\">\r\n");
      out.write("\t\t\t\t\t\t<td>티켓 금액</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"background-color: white\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ticketprice}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("원</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr class=\"prheight\">\r\n");
      out.write("\t\t\t\t\t\t<td>예매 수수료</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"background-color: white\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vat}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("원</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr class=\"prheight\">\r\n");
      out.write("\t\t\t\t\t\t<td>총 금액</td>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"background-color: white\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${totalprice}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("원</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t   \t\t</table>\r\n");
      out.write("\t\t   \t\t<div class=\"rvbutton\">\r\n");
      out.write("\t\t   \t\t\t<button class=\"bt\" onclick=\"backstep()\" id=\"step\">Prev</button>\r\n");
      out.write("\t\t   \t\t\t<button class=\"bt\" onclick=\"nextseat()\" id=\"step\">Next</button>\r\n");
      out.write("\t\t   \t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("/* \twindow.addEventListener(\"beforeunload\", function (e) {\r\n");
      out.write("\r\n");
      out.write("\t  var confirmationMessage = \"Are you sure you want to leave this page without placing the order ?\";\r\n");
      out.write("\t  (e || window.event).returnValue = confirmationMessage;\r\n");
      out.write("\t  return confirmationMessage;\r\n");
      out.write("\r\n");
      out.write("\t}); */\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t var secret =\"\";\r\n");
      out.write("\t var time = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${time}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t var checktime =\"\";\r\n");
      out.write("\t var now =\"\";\r\n");
      out.write("\t // session에 저장된 시간과 현재 시간을 매초 비교하여 5분 초과 시 예매 취소\r\n");
      out.write("\t var playAlert = setInterval(function() {\r\n");
      out.write("\t\t checktime = new Date();\r\n");
      out.write("\t\t now = checktime.getHours() + \"\" + checktime.getMinutes();\r\n");
      out.write("\t\t now *=1;\r\n");
      out.write("\t\t time *=1;\r\n");
      out.write("\t \t if( time < now ){\r\n");
      out.write("\t\t\t clearInterval(playAlert);\r\n");
      out.write("\t\t\t secret = \"1\";\t\t \r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t}, 1000);\r\n");
      out.write("\t\r\n");
      out.write("\t // 우편번호 찾기\r\n");
      out.write("\t function setaddress() {\r\n");
      out.write("\t     \tvar width = 500;\r\n");
      out.write("\t    \tvar height = 600;\r\n");
      out.write("\t    \tdaum.postcode.load(function(){\r\n");
      out.write("\t    \t\tnew daum.Postcode({\r\n");
      out.write("\t    \t\t\toncomplete: function( data ) {\r\n");
      out.write("\t    \t\t\t\t$(\"#shipping_address\").val(data.roadAddress);\r\n");
      out.write("\t    \t\t\t}\t\r\n");
      out.write("\t    \t\t}).open({\r\n");
      out.write("\t    \t\t\tleft: (window.screen.width/2 ) - ( width/2 ),\r\n");
      out.write("\t    \t\t\ttop: (window.screen.height/2 ) - ( height/2 ) \r\n");
      out.write("\t    \t\t});\r\n");
      out.write("\t    \t});\r\n");
      out.write("\t    \t\r\n");
      out.write("\t }\r\n");
      out.write("\t \r\n");
      out.write("\t \r\n");
      out.write("\t// 배송정보에서 이전단계로 가기\r\n");
      out.write("\tfunction backstep(){\r\n");
      out.write("\t\tif ( secret == \"\") {\r\n");
      out.write("\t\t\tvar seat = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seat}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\tvar level = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${level}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\tif( confirm(\"이전 단계로 이동 시 예매정보가 모두 취소 됩니다\") == true ){\r\n");
      out.write("\t\t\t\tvar date = $(\"#date\").val();\r\n");
      out.write("\t\t\t\tvar address = \"reservation.do?level=\"+ level + \"&seat=\" + seat + \"&date=\" + date; \r\n");
      out.write("\t\t\t\tlocation.replace(address);\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn;\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tseatdelete();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t// 예매 완료하고 마이페이지로 가기\r\n");
      out.write("\tfunction nextseat(){\r\n");
      out.write("\t\tif ( secret == \"\") {\r\n");
      out.write("\t\t\tvar idcheck = $('#shipping_name').val();\r\n");
      out.write("\t\t\tvar phonecheck = $('#shipping_phone').val();\r\n");
      out.write("\t\t\tvar addresscheck = $('#shipping_address').val();\r\n");
      out.write("\t\t\tif( !idcheck || !phonecheck || !addresscheck ) {\r\n");
      out.write("\t\t\t\talert(\"배송정보를 입력해 주세요\");\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\tmethod: \"POST\",\r\n");
      out.write("\t\t\t\t\turl: \"mpinsert.do\",\r\n");
      out.write("\t\t\t\t\tdata: $(\"#shippingForm\").serialize(),\r\n");
      out.write("\t\t\t\t\tsuccess : function(result){\r\n");
      out.write("\t\t\t\t\t if(result.code == \"OK\"){\r\n");
      out.write("\t\t\t\t\t\talert(\"예매가 완료되었습니다.\");\r\n");
      out.write("\t\t\t\t\t\tvar address = \"mypage.do\"\r\n");
      out.write("\t\t\t\t\t\twindow.opener.location.replace(address);\r\n");
      out.write("\t\t\t\t\t\twindow.close();\r\n");
      out.write("\t\t\t\t\t }else{\r\n");
      out.write("\t\t\t\t\t alert(\"fail\");\r\n");
      out.write("\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror:function(request,status,error){\r\n");
      out.write("\t\t\t\t\t      alert(\"code:\"+request.status+\"\\n\"+\"message:\"+request.responseText+\"\\n\"+\"error:\"+error);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tseatdelete();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t// 5분 시간초과로 인한 예매 취소 \r\n");
      out.write(" \tfunction seatdelete(){\r\n");
      out.write("\t\t\tvar seat = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seat}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\tvar level = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${level}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\tvar match_num = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${match.get(0).match_num}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t  method: \"POST\",\r\n");
      out.write("\t\t\t\t  url: \"seatdelete.do\",\r\n");
      out.write("\t\t\t\t  data: {\r\n");
      out.write("\t\t\t\t\t  level : level,\r\n");
      out.write("\t\t\t\t\t  seat : seat,\r\n");
      out.write("\t\t\t\t\t  match_num : match_num\r\n");
      out.write("\t\t\t\t  },\r\n");
      out.write("\t\t\t\t  success : function(result){\r\n");
      out.write("\t\t\t\t\t  if(result.code == \"OK\"){\r\n");
      out.write("\t\t\t\t\t\t  alert(\"5분 내 결제가 이루어지지 않아 예매가 취소됩니다.\");\r\n");
      out.write("\t\t\t\t\t\t  window.close();\r\n");
      out.write("\t\t\t\t\t  }else{\r\n");
      out.write("\t\t\t\t\t\t alert(\"fail\");\r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t  },\r\n");
      out.write("\t\t\t\t  error:function(request,status,error){\r\n");
      out.write("\t\t\t\t        alert(\"code:\"+request.status+\"\\n\"+\"message:\"+request.responseText+\"\\n\"+\"error:\"+error);\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t// 주문자 정보와 동일할 경우\r\n");
      out.write("    $(\"#chbox\").change(function(){\r\n");
      out.write("        if($(\"#chbox\").is(\":checked\")){\r\n");
      out.write("            $.ajax({\r\n");
      out.write("\t\t\t\t  method: \"POST\",\r\n");
      out.write("\t\t\t\t  url: \"userselect.do\",\r\n");
      out.write("\t\t\t\t  data: {\r\n");
      out.write("\t\t\t\t  },\r\n");
      out.write("\t\t\t\t  success : function(result){\r\n");
      out.write("\t\t\t\t\t  if(result.code == \"OK\"){\r\n");
      out.write("\t\t\t\t\t\t  \tvar name = result.user.name;\r\n");
      out.write("\t\t\t\t\t\t  \tvar phone = result.user.phone;\r\n");
      out.write("\t\t\t\t\t\t\tvar address = result.user.address;\r\n");
      out.write("\t\t\t\t\t\t  \t$('#shipping_name').val(name);\r\n");
      out.write("\t\t\t\t\t\t  \t$('#shipping_phone').val(phone);\r\n");
      out.write("\t\t\t\t\t\t  \t$('#shipping_address').val(address);\r\n");
      out.write("\t\t\t\t\t  }else{\r\n");
      out.write("\t\t\t\t\t\t alert(\"fail\");\r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t  },\r\n");
      out.write("\t\t\t\t  error:function(request,status,error){\r\n");
      out.write("\t\t\t\t        alert(\"code:\"+request.status+\"\\n\"+\"message:\"+request.responseText+\"\\n\"+\"error:\"+error);\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("        }else{\r\n");
      out.write("        \t$('#shipping_name').val(\"\");\r\n");
      out.write("\t\t  \t$('#shipping_phone').val(\"\");\r\n");
      out.write("\t\t  \t$('#shipping_address').val(\"\");\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/resvcheck.jsp(77,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("i");
      // /WEB-INF/views/resvcheck.jsp(77,5) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setBegin(0);
      // /WEB-INF/views/resvcheck.jsp(77,5) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setEnd(3);
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t");
            if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
              return true;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t");
            if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
              return true;
            out.write("\r\n");
            out.write("\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
      // /WEB-INF/views/resvcheck.jsp(78,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty st[i]}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<tr class=\"rvheight\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${level}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("석</td>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st[i]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
      // /WEB-INF/views/resvcheck.jsp(84,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty st[i]}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<tr class=\"rvheight\">\r\n");
          out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
          out.write("\t\t\t\t\t\t\t\t<td></td>\r\n");
          out.write("\t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }
}
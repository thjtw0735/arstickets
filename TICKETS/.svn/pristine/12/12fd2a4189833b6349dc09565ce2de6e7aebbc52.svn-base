package com.tonmedia.tickets.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tonmedia.tickets.domain.User;

import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileInputStream;
 
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;




/**-*
 * Handles requests for the application home page.
 */
@Controller
public class NewUploadController {
	
	@Autowired
	com.tonmedia.tickets.mapper.UserMapper UserMapper;
	
    private static final Logger logger = LoggerFactory.getLogger(NewUploadController.class);

	public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}

    @Resource(name="uploadPath")
    String uploadPath;  
    
	@ResponseBody
    @RequestMapping(value="uploadForm.do", method=RequestMethod.POST)
    public String uplodaForm(/*MultipartFile file*/ MultipartHttpServletRequest file, User user, HttpServletRequest request) throws Exception {
		

        //String savedName = file.getOriginalFilename(); //abc.jpg
        //String savedImg = "\\image\\"+ savedName;
        
        String email = (String)request.getSession().getAttribute("email");
        System.out.println(email);
        
        //user.setImage(savedImg);
        //user.setEmail(email);
        
        // this.UserMapper.upload(user);
        
        //ftp 파일업로드
        
        String username = "root";
        String host = "106.10.46.16";
        int port = 22;
        String password = "1234";
        
       // String localFile = "D:\\image\\" + savedName; // 전송 파일 위치(로컬)
        String serverPath = "/root/upload"; // 대상 디렉토리(서버)
        // 변수 설정 end
        
    	
	/*	if( mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")){
			
		} else {
			for( int i=0; i< mf.size(); i++ ){
				File ftpfile =  multipartToFile(mf.get(0));
			}
		}
        */
        
/*        File ftpfile =  new File(uploadPath, savedName);
        File ftpfile = target;*/
    /*    File ftpfile = new File(localFile);*/
        
        
 
        System.out.println("=> Connecting to " + host);
         
        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
 
        FileInputStream in = null;
        
        JSch jsch = new JSch();
 
        try {
            session = jsch.getSession(username, host, port);
            session.setPassword(password);
         
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no"); // 인증서 검사를 하지 않음
            session.setConfig(config);
            
            session.connect();
 
            channel = session.openChannel("sftp");
            channel.connect();
 
            channelSftp = (ChannelSftp)channel;
            System.out.println("=> Connected to " + host);
 
            Iterator<String> files = file.getFileNames();
            while(files.hasNext() ){
            	String uploadFile = files.next();
            	MultipartFile multifile = file.getFile(uploadFile);
            	File ftpfile = multipartToFile(multifile);
            	
            	/*File ftpfile = multipartToFile(mf.get(i));*/
            	System.out.println("2");
            	in = new FileInputStream( ftpfile );
            	System.out.println("3");
            	channelSftp.cd(serverPath);
            	System.out.println("4");
            	channelSftp.put(in, ftpfile.getName());
            	System.out.println("5");
            }
            
            
 
            
//            System.out.println("=> Uploaded : " + convFile.getPath() + " at " + host);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                channelSftp.exit();
                channel.disconnect();
                session.disconnect();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        
        String a = "0";
        return a; // uploadResult.jsp(결과화면)로 포워딩
    }
}
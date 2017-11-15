package com.chdsxt.crm.init;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import com.chdsxt.crm.po.Role;
import com.chdsxt.crm.service.RoleService;
import com.chdsxt.crm.service.impl.RoleServiceImpl;

@SuppressWarnings("serial")
public class InitRoleServlet extends HttpServlet {
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	public void init() throws ServletException {
		RoleService roleService  = new RoleServiceImpl();
		List<Role>  roleList = roleService.queryRoleList();
		this.getServletContext().setAttribute("roleList",roleList);
		String path = this.getServletContext().getRealPath("/resources");
		System.out.println("====="+path+"=====");
		this.getServletContext().setAttribute("realPath",path);
	
		List<String> photoList = new ArrayList<String>();
		File basefile = new File(path);
        if(basefile.length()>0){
        	String[] filenames1 = basefile.list(new FilenameFilter(){
                //file 过滤目录 name 文件名
                public boolean accept(File file,String filename){
                    return filename.endsWith(".jpg");
                }
            });
        	String[] filenames2 = basefile.list(new FilenameFilter(){
                //file 过滤目录 name 文件名
                public boolean accept(File file,String filename){
                    return filename.endsWith(".jpeg");
                }
            });
        	
        	for (String filename : filenames1) {
        		System.out.println("----- "+"resources/"+filename+" -----");
        		photoList.add("resources/"+filename);	
    		}
        	for (String filename : filenames2) {
        		System.out.println("----- "+"resources/"+filename+" -----");
        		photoList.add("resources/"+filename);	
    		}
        }
        this.getServletContext().setAttribute("photoList",photoList);
	}

}

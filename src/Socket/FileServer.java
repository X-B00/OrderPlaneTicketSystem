package Socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) {
        try {
            //0~65535之间：0~1024以内的最好别用，给操作系统
            ServerSocket ss = new ServerSocket(9889);  //端口号
            Socket socket=ss.accept();

            OutputStream os=socket.getOutputStream();

            FileInputStream fis=new FileInputStream("F:\\duyin.mp3");  //发送的文件
            byte buff[]=new byte[1024];
            int a=0;
            while((a=fis.read(buff))!=-1){
                os.write(buff,0,a);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package httpsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class HTTPSocket {

	Socket socket = null;
	
	public HTTPSocket(String host,int port) {
	try {
		socket = new Socket(host,port);
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
 	}
	
	public void sendRequest() throws IOException {
		String request = "GET / HTTP/1,1\r\n" +
				"Host: localhost\r\n" +
				"Content-type: test/xml; charset=ISO-8859-1\r\n\r\n";
		
		OutputStream os = socket.getOutputStream();
		os.write(request.getBytes());
		os.flush();
	}
	public void receiveResponse() throws IOException {
		InputStream is = socket.getInputStream();
		int ch;
		while ((ch = is.read()) != -1) {
			System.out.print((char) ch);
		}
	}
	public static void main(String[] args){
		HTTPSocket httpsocket = new HTTPSocket("www.gmail.com", 80);
		try {
			httpsocket.sendRequest();
			httpsocket.receiveResponse();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

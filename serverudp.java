import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class serverudp {
    public static void main(String[] args) throws IOException, InterruptedException
    {
        // Step 1 : Create a socket to listen at port 5000
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] receive = new byte[65535];
  
        DatagramPacket DpReceive = null;
        while (true)
        {
  
            // Step 2 : create a DatgramPacket to receive the data.
            DpReceive = new DatagramPacket(receive, receive.length);
  
            // Step 3 : revieve the data in byte buffer.
            ds.receive(DpReceive);
  
            System.out.println("Client:-" + data(receive));
            
            String a="0";
            String b="1";
    
            if (data(receive).toString().equals(a))
            {
                System.out.println(data(receive).toString());
                try {
                    String lscmd = "ls ";
                    Process prc=Runtime.getRuntime().exec(lscmd);
                    prc.waitFor();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(prc.getInputStream()));
                    String line=reader.readLine();
                    while(line!=null){
                        System.out.println(line);
                        line=reader.readLine();
                    }
                } 
                catch (IOException e) {
                    System.out.println(e); 
                }

                break;
            }
            else if (data(receive).toString().equals(b))
            {
                String lscmd = "date";
                Process p=Runtime.getRuntime().exec(lscmd);
                p.waitFor();
                BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
                String li=reader.readLine();
                System.out.println(li);
                break;
            }
            // Exit the server if the client sends "bye"
            else if (data(receive).toString().equals("bye"))
            {
                System.out.println("Client sent bye.....EXITING");
                break;
            }
  
            // Clear the buffer after every message.
            receive = new byte[65535];
        }
    }

    // A utility method to convert the byte array
    // data into a string representation.
    public static StringBuilder data(byte[] a) {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
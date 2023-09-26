import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

class Class_20 {
    public static void receive() {
        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(null));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(null, 0));
            int number = dis.readInt();
            ArrayList<File> files = new ArrayList<File>(number);
            System.out.println("Number of Files to be received: " + number);
            for (int i = 0; i < number; i++) {
                File file = new File(dis.readUTF());
                files.add(file);
            }
            int n = 0;
            byte[] buf = new byte[4092];
            for (int i = 0; i < files.size(); i++) {
                System.out.println("Receiving file: " + files.get(i).getName());
                FileOutputStream fos = new FileOutputStream("C:\\users\\tom5\\desktop\\salestools\\" + files.get(i).getName());
                while ((n = dis.read(buf)) != -1) {
                    fos.write(buf, 0, n);
                    fos.flush();
                }
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(ArrayList<File> files) {
        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(null));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(null));
            System.out.println(files.size());
            dos.writeInt(files.size());
            dos.flush();
            for (int i = 0; i < files.size(); i++) {
                dos.writeUTF(files.get(i).getName());
                dos.flush();
            }
            int n = 0;
            byte[] buf = new byte[4092];
            for (int i = 0; i < files.size(); i++) {
                System.out.println(files.get(i).getName());
                FileInputStream fis = new FileInputStream(files.get(i));
                while ((n = fis.read(buf)) != -1) {
                    dos.write(buf, 0, n);
                    dos.flush();
                }
            }
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class BinaryExample {
    Socket mSocket;
    String mServer = "127.0.0.1";
    int mServerPort = 123;
    byte[] header = {0x53, 0x41, 0x4D, 0x50, 0x4C, 0x45}; // SAMPLE
    int mProtocolVersion = 0;
    OutputStream mOutputStream;
    InputStream mInputStream;
    BufferedOutputStream mBufferedOutputStream;
 
    public void run() {
        try {
            // set up connection with server
            this.mSocket = new Socket(mServer, mServerPort);
        } catch (Exception ee) {
            return;
        }
 
        // get the I/O streams for the socket.
        try {
            mOutputStream = this.mSocket.getOutputStream();
            mBufferedOutputStream = new BufferedOutputStream(mOutputStream);
            mInputStream = this.mSocket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
 
        byte version = (byte) mProtocolVersion;
        int messageLength = 4 + header.length + version.length;
        byte[] msgSize = intToByteArray(messageLength);
 
        // write to the socket
        try {
            mBufferedOutputStream.write(msgSize);
            mBufferedOutputStream.write(header);
            mBufferedOutputStream.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
 
        // Writes provided 4-byte integer to a 4 element byte array in Little-Endian order.
        public static final byte[] intToByteArray(int value) {
            return new byte[] {
                (byte)(value & 0xff),
                (byte)(value >> 8 & 0xff),
                (byte)(value >> 16 & 0xff),
                (byte)(value >>> 24)
            };
        }
    }
}
package com.kurt_financial.api.security.jwt;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

public class RequestWrapper extends HttpServletRequestWrapper {
    private final byte[] requestBody;

    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        requestBody = getRequestBodyBytes(request);
    }

    private byte[] getRequestBodyBytes(HttpServletRequest request) throws IOException {
        try (InputStream inputStream = request.getInputStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new CachedServletInputStream(requestBody);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(requestBody);
        return new BufferedReader(new InputStreamReader(inputStream, getCharacterEncoding()));
    }

    public String getRequestBody() throws UnsupportedEncodingException {
        return new String(requestBody, getCharacterEncoding());
    }

    private static class CachedServletInputStream extends ServletInputStream {
        private final ByteArrayInputStream inputStream;

        public CachedServletInputStream(byte[] requestBody) {
            inputStream = new ByteArrayInputStream(requestBody);
        }

        @Override
        public boolean isFinished() {
            return inputStream.available() == 0;
        }

        @Override
        public int read() throws IOException {
            return inputStream.read();
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            return inputStream.read(b, off, len);
        }

        @Override
        public int read(byte[] b) throws IOException {
            return inputStream.read(b);
        }

        @Override
        public void setReadListener(ReadListener listener) {
            // Implemente esse método, se necessário
        }

        @Override
        public boolean isReady() {
            // Implemente esse método, se necessário
            return true;
        }
    }
}
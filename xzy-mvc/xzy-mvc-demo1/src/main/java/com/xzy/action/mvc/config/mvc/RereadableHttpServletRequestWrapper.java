package com.xzy.action.mvc.config.mvc;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * 增强HttpServletRequest，使其可重复读取
 *
 * @author xzy.xiao
 * @since 2024/12/24  9:25
 */
public class RereadableHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private ByteArrayOutputStream originalRequestInputStream;

    public RereadableHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        // Save original request input stream
        if (originalRequestInputStream == null) {
            originalRequestInputStream = new ByteArrayOutputStream();
            IOUtils.copy(super.getInputStream(), originalRequestInputStream);
        }

        // Create backup request input stream
        return new BackupServletInputStream(originalRequestInputStream.toByteArray());
    }

    @Override
    public BufferedReader getReader() throws IOException {
        ServletInputStream backupServletInputStream = getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(backupServletInputStream);
        return new BufferedReader(inputStreamReader);
    }

    // SUPPORT

    public static class BackupServletInputStream extends ServletInputStream {

        private final ByteArrayInputStream backupRequestInputStream;

        public BackupServletInputStream(byte[] buf) {
            backupRequestInputStream = new ByteArrayInputStream(buf);
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener listener) {
        }

        @Override
        public int read() throws IOException {
            return backupRequestInputStream.read();
        }
    }
}

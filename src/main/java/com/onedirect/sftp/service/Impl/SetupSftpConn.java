package com.onedirect.sftp.service.Impl;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.onedirect.sftp.config.RemoteSftp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetupSftpConn {
    @Autowired
    RemoteSftp remoteSftp;
    public ChannelSftp setupJsch() throws JSchException {
        JSch jsch = new JSch();
        jsch.setKnownHosts(remoteSftp.getHost());
        Session jschSession = jsch.getSession(remoteSftp.getUsername(), remoteSftp.getHost());
        jschSession.setPassword(remoteSftp.getPassword());
        jschSession.connect();
        return (ChannelSftp) jschSession.openChannel("sftp");
    }
}

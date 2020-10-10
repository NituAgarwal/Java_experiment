package com.landon.chat.model;

import java.util.Date;

public class ChatOutMessage {

    private String contents;
    private String groupName;
    private Date sentTimestamps;

    public ChatOutMessage(){

    }

    public ChatOutMessage(String message){
        this.contents = message;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getSentTimestamps() {
        return sentTimestamps;
    }

    public void setSentTimestamps(Date sentTimestamps) {
        this.sentTimestamps = sentTimestamps;
    }

}

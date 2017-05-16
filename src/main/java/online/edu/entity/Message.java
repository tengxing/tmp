package online.edu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Describe: 留言
 */
public class Message extends InitModel implements Serializable {

    private Integer id;
    private String nickName;
    private String phoneNumber;
    private String mail;
    private String title;
    private String content;
    private Date messageTime;
    private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", nickName=" + nickName + ", phoneNumber=" + phoneNumber + ", mail=" + mail
				+ ", title=" + title + ", content=" + content + ", messageTime=" + messageTime + ", status=" + status
				+ "]";
	}

    
    
}

package com.ys.entity;

public class Wenzhang extends BaseBean {
	private String title;
	private String neirong;
	private String suoluetu;
	private String zaiyao;
	private String zuozhe;
	private String date;
	private int Liulanshu;
	public int getLiulanshu() {
		return Liulanshu;
	}
	public void setLiulanshu(int i) {
		this.Liulanshu= Liulanshu;
	}
	private int pinglunshu;
	private int fenlei;
	private String biaoqian;
	public Wenzhang() {
		super();
	}
	public Wenzhang(int id,String title, String neirong, String suoluetu, String zaiyao, String zuozhe, String date,
			int liulanshu, int pinglunshu, int fenlei, String biaoqian) {
		super(id);
		this.title = title;
		this.neirong = neirong;
		this.suoluetu = suoluetu;
		this.zaiyao = zaiyao;
		this.zuozhe = zuozhe;
		this.date = date;
		this.pinglunshu = pinglunshu;
		this.fenlei = fenlei;
		this.biaoqian = biaoqian;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String string) {
		this.neirong = string;
	}
	public String getSuoluetu() {
		return suoluetu;
	}
	public void setSuoluetu(String suoluetu) {
		this.suoluetu = suoluetu;
	}
	public String getZaiyao() {
		return zaiyao;
	}
	public void setZaiyao(String zaiyao) {
		this.zaiyao = zaiyao;
	}
	public String getZuozhe() {
		return zuozhe;
	}
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public int getPinglunshu() {
		return pinglunshu;
	}
	public void setPinglunshu(int pinglunshu) {
		this.pinglunshu = pinglunshu;
	}
	public int getFenlei() {
		return fenlei;
	}
	public void setFenlei(int fenlei2) {
		this.fenlei = fenlei2;
	}
	public String getBiaoqian() {
		return biaoqian;
	}
	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}
	
	
}

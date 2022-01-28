package dao;

import model.User;

import java.util.List;

import model.Article;

public interface IDAO <T>{
	public boolean mailExist(String object);
	public User login(String mail, String password);
	public boolean create(Article object);
	public List<T> read();
}
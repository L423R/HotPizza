package com.zgt.project.my.pizza;

import com.zgt.project.my.pizza.dao.DrinkDao;
import com.zgt.project.my.pizza.dao.OrderDao;
import com.zgt.project.my.pizza.dao.PizzaDAO;
import com.zgt.project.my.pizza.dao.UserDao;
import com.zgt.project.my.pizza.entitys.DrinksEntity;
import com.zgt.project.my.pizza.entitys.PizzaEntity;
import com.zgt.project.my.pizza.entitys.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
@Scope("session")
@Transactional
public class PizzaService {

	@Autowired
	PizzaDAO pizzaDAO;
	@Autowired
	DrinkDao drinkDao;
	@Autowired
    OrderDao orderDao;
	@Autowired
    UserDao userDao;

	private UserEntity user;

	private HashMap<Item,Integer> listMap = new HashMap<>();

	
	public void addToOrder(int id,String clazz){

		Item byName=null;
		if (clazz.equals("pizza")){
			byName = pizzaDAO.getById(id);
		}else if (clazz.equals("drink")){
			byName = drinkDao.getById(id);
		}


		if (listMap.containsKey(byName))
		{
			listMap.put(byName,listMap.get(byName)+1);
		}else listMap.put(byName,1);

	}

	public void ZeroCash()
    {
    }
	
	public int cashFromCart()
	{
		
		int cash=0;
		if (listMap!=null){
			for (Map.Entry entry : listMap.entrySet()){
				cash+=cashFromItem(entry);
			}
		}
		return cash;
	}
	
	private int cashFromItem(Map.Entry entry)
	{
		Item item = (Item) entry.getKey();
		return item.getPrice()*(Integer)entry.getValue();
	}

	public List<PizzaEntity> getPizzaList() {
		return pizzaDAO.getAll();
	}

	public List<DrinksEntity> getDrinkList() {
		return drinkDao.getAll();
	}

	public ArrayList<String> getItemList() {

		ArrayList<String> list = new ArrayList<>();

		if (listMap!=null) {
			for (Map.Entry entry:listMap.entrySet())
			{
				Item item = (Item) entry.getKey();
				Integer value = (Integer) entry.getValue();
				String s = item.getName()+"-"+value;
				list.add(s);
			}
		}
		return list;
	}

	public UserEntity getUser() {
		if (user!= null) {
			return user;
		}		else return new UserEntity();
	}

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserEntity getUserById(int id)
	{
		return userDao.getUserById(id);

	}

}

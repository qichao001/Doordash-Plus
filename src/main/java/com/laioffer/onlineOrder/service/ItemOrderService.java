package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.CustomerDao;
import com.laioffer.onlineOrder.dao.MenuInfoDao;
import com.laioffer.onlineOrder.dao.OrderItemDao;
import com.laioffer.onlineOrder.entity.Customer;
import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ItemOrderService {
    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private MenuInfoDao menuInfoDao;

    @Autowired
    private CustomerDao customerDao;

    public void saveItem(int menuId) {
        OrderItem orderItem = new OrderItem();
        MenuItem menuItem = menuInfoDao.getMenuItem(menuId);

        Authentication loggedinUser = SecurityContextHolder.getContext().getAuthentication();
        String  email = loggedinUser.getName();
        Customer customer = customerDao.getCustomer(email);

        orderItem.setMenuItem(menuItem);
        orderItem.setQuantity(1);
        orderItem.setPrice(orderItem.getQuantity() * menuItem.getPrice());
        orderItem.setCart(customer.getCart());

        orderItemDao.save(orderItem);
    }
}

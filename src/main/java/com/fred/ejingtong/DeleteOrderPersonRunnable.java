package com.fred.ejingtong;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version 1.7
 * @since 2015/7/8
 */
public class DeleteOrderPersonRunnable implements Runnable {

    public static DeleteOrderPersonRunnable instance = null;

    public static DeleteOrderPersonRunnable getInstance() {

        if (null == instance) {
            synchronized (DeleteOrderPersonRunnable.class) {

                if (null == instance) {
                    instance = new DeleteOrderPersonRunnable();
                }
            }
        }
        return instance;
    }

    private DeleteOrderPersonRunnable() {

    }

    @Override
    public void run() {

        System.out.println("delete order person");
        String sql = "delete from order_person where order_id in(select order_id from ord_order where used_status != 'UNUSED' AND sync_status = 0  AND sync_time is not null limit 20)";
        String clientId = PropertiesUtil.clientId;
        HttpUtil.get(sql, clientId);
    }
}

package com.fred.ejingtong;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version 1.7
 * @since 2015/7/8
 */
public class DeleteOrderMetaRunnable implements Runnable {

    public static DeleteOrderMetaRunnable instance = null;

    public static DeleteOrderMetaRunnable getInstance() {

        if (null == instance) {
            synchronized (DeleteOrderMetaRunnable.class) {

                if (null == instance) {
                    instance = new DeleteOrderMetaRunnable();
                }
            }
        }
        return instance;
    }

    private DeleteOrderMetaRunnable() {

    }

    @Override
    public void run() {

        System.out.println("delete order meta");
        String sql = "delete from order_item where order_id in( select order_id from ord_order where used_status != 'UNUSED' AND sync_status = 0  AND sync_time is not null limit 20)";
        String clientId = PropertiesUtil.clientId;
        HttpUtil.get(sql, clientId);

    }
}

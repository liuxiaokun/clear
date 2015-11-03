package com.fred.ejingtong;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version 1.7
 * @since 2015/7/8
 */
public class DeleteLogRunnable implements Runnable {

    public static DeleteLogRunnable instance = null;

    public static DeleteLogRunnable getInstance() {

        if (null == instance) {
            synchronized (DeleteLogRunnable.class) {

                if (null == instance) {
                    instance = new DeleteLogRunnable();
                }
            }
        }

        return instance;
    }

    private DeleteLogRunnable() {

    }

    @Override
    public void run() {

        System.out.println("delete log");
        String sql = "delete from log where log_id in ( select log_id from log order by log_id limit 50 )";
        String clientId = PropertiesUtil.clientId;
        HttpUtil.get(sql, clientId);
    }
}

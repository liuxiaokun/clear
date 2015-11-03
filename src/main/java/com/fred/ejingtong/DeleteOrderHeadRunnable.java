package com.fred.ejingtong;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version 1.7
 * @since 2015/7/8
 */
public class DeleteOrderHeadRunnable implements Runnable {

    public static DeleteOrderHeadRunnable instance = null;

    public static DeleteOrderHeadRunnable getInstance() {

        if (null == instance) {
            synchronized (DeleteOrderHeadRunnable.class) {

                if (null == instance) {
                    instance = new DeleteOrderHeadRunnable();
                }
            }
        }
        return instance;
    }

    private DeleteOrderHeadRunnable() {

    }

    @Override
    public void run() {

        int i = 0;

        System.out.println("delete order head" + i++);
    }
}

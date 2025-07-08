public class App {
    public static void main(String[] args) throws Exception {
        // Exemplo de Thread única
        // SingletonLazy singletonLazy1 = SingletonLazy.getIstance();
        // SingletonLazy singletonLazy2 = SingletonLazy.getIstance();
        // if (singletonLazy1 == singletonLazy2) {
        // System.out.println("Deu bom demais!");
        // } else {
        // System.out.println("Algo falou aqui :()");
        // }

        // Exemplo de múltiplas Threads
        Thread threadUm = new Thread(new ThreadUm());
        Thread threadDois = new Thread(new ThreadDois());
        threadUm.start();
        threadDois.start();

        // Exemplo multithreds com Safe Lazy
        Thread threadOne = new Thread(new ThreadSafeOne());
        Thread threadTwo = new Thread(new ThreadSafeTwo());
        threadOne.start();
        threadTwo.start();

    }

    static class ThreadSafeOne implements Runnable {

        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
            System.out.println(singleton.toString());
        }
    }

    static class ThreadSafeTwo implements Runnable {

        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
            System.out.println(singleton.toString());
        }
    }

    static class ThreadUm implements Runnable {

        @Override
        public void run() {
            SingletonLazy singletonLazy = SingletonLazy.getInstance();
            System.out.println(singletonLazy.toString());
        }
    }

    static class ThreadDois implements Runnable {

        @Override
        public void run() {
            SingletonLazy singletonLazy = SingletonLazy.getInstance();
            System.out.println(singletonLazy.toString());
        }
    }
}

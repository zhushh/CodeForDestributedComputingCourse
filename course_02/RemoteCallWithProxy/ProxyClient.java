public class ProxyClient {
    public static void main(String[] args) throws Exception {
        StaticServiceProxy service1 = new StaticServiceProxy("localhost", 8000);
        System.out.println(service1.getAccount("Zhang3"));

        AccountService service2 = (AccountService)DynamicProxyFactory.getProxy(AccountService.class, 
                                                                            "localhost", 8000);
        System.out.println(service2.getAccount("Li4"));
    }
}

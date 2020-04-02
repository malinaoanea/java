public class OutTask implements Task {
    private String message;

    public OutTask(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public void doSomething() {
        System.out.println(this.getMessage());
    }
}

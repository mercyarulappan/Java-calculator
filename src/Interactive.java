class Interactive{
    private int a;
    private int b;
    Interactive(int a,int b){
        this.a = a;
        this.b = b;
    }
    public int add(int a, int b)
    {
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
    public int mul(int a, int b){
        return a*b;
    }
    public double div(int a, int b){
        if(b==0) return Double.POSITIVE_INFINITY;
        return a/b;
    }
    public double sin(int angle)
    {
        return Math.sin(angle);
    }
    public double cos(int angle){
        return Math.cos(angle);
    }
    public double tan(int angle){
        return Math.tan(angle);
    }
}
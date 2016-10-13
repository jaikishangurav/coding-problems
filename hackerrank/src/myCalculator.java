class myCalculator
    {
    public myCalculator(){
        
    }
    
    public int power(int n, int p) throws Exception{
        if(p<0||n<0){
            throw new Exception("n and p should be non-negative");
        }
        else{
        if(p>0){
        return n*(power(n,p-1));
        }
        else 
        	return 1;
        }
        
}
}
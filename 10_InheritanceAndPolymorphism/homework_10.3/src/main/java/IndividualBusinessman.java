public class IndividualBusinessman extends Client  {
    @Override
    public void put(double amountToPut) {
        if(amountToPut < 1000) {
            super.put(amountToPut - (amountToPut  / 100 * 1));
        }else if (amountToPut >= 1000){
            super.put(amountToPut -( amountToPut  / 100 * 0.5));
        }
    }

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake);
    }
}

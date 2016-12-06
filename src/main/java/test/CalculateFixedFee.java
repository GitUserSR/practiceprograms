package test;

public class CalculateFixedFee {

	public static void main(String[] args) {
		
		//100 Enforcement module Level_data='VirtualMerchant_Test_Enforcement and ConvenienceFeeFormula=0.03,1,0,1,999999,9999999
		//160 AMS module Level_data='VirtualMerchant_Test_AMS and ConvenienceFeeFormula=0,1,1,1,34.99,34.99, 0.02,1,0,1,9999999,999999
		
		/*AMS*/ double fee=160 , a0=0.02 ,  a1=1 , a2=0,a3=1;
		/*ENFORCEMENT  double fee=100 , a0=0.03 ,  a1=1 , a2=0,a3=1; */
		
		double totalFee = fee * a0 / a1 + a2;
		System.out.println(totalFee);
	}

}

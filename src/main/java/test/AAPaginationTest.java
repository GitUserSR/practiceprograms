package test;

public class AAPaginationTest {

	public static void main(String[] args) {

		int totalCount = 1;
		int pageSize = 5;
		int maxPages = 10;
		int pageNo = 0;
		String pageNum = null ;
		
		int test = 6 % 5;
		
		if (maxPages * pageSize >= totalCount)
		{
			if (totalCount % pageSize > 0)
			{
				pageNo = (maxPages - 1) * pageSize + totalCount % pageSize;
			}
			else
			{
				pageNo = maxPages * pageSize;
			}
		}
		else
		{
			pageNum = String.valueOf(maxPages * pageSize);
		}
		
		System.out.println(pageNo);
		System.out.println(pageNum);
		
		System.out.println((int)Math.ceil(totalCount/pageSize));

	}
}

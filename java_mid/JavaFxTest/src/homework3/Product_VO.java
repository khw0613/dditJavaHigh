package homework3;

public class Product_VO {
	private String prod_Id;
	private String prod_Name;
	private String prod_Lgu;
	private String prod_Buyer;
	private String prod_Cost;
	private String prod_Price;
	private String prod_Sale;
	private String prod_Outline;
	private String prod_Detail;
	
	
	public Product_VO(String prod_Id, String prod_Name, String prod_Lgu, String prod_Buyer, String prod_Cost,
			String prod_Price, String prod_Sale, String prod_Outline, String prod_Detail) {
		super();
		this.prod_Id = prod_Id;
		this.prod_Name = prod_Name;
		this.prod_Lgu = prod_Lgu;
		this.prod_Buyer = prod_Buyer;
		this.prod_Cost = prod_Cost;
		this.prod_Price = prod_Price;
		this.prod_Sale = prod_Sale;
		this.prod_Outline = prod_Outline;
		this.prod_Detail = prod_Detail;
	}


	public Product_VO() {

	}


	public String getProd_Id() {
		return prod_Id;
	}


	public void setProd_Id(String prod_Id) {
		this.prod_Id = prod_Id;
	}


	public String getProd_Name() {
		return prod_Name;
	}


	public void setProd_Name(String prod_Name) {
		this.prod_Name = prod_Name;
	}


	public String getProd_Lgu() {
		return prod_Lgu;
	}


	public void setProd_Lgu(String prod_Lgu) {
		this.prod_Lgu = prod_Lgu;
	}


	public String getProd_Buyer() {
		return prod_Buyer;
	}


	public void setProd_Buyer(String prod_Buyer) {
		this.prod_Buyer = prod_Buyer;
	}


	public String getProd_Cost() {
		return prod_Cost;
	}


	public void setProd_Cost(String prod_Cost) {
		this.prod_Cost = prod_Cost;
	}


	public String getProd_Price() {
		return prod_Price;
	}


	public void setProd_Price(String prod_Price) {
		this.prod_Price = prod_Price;
	}


	public String getProd_Sale() {
		return prod_Sale;
	}


	public void setProd_Sale(String prod_Sale) {
		this.prod_Sale = prod_Sale;
	}


	public String getProd_Outline() {
		return prod_Outline;
	}


	public void setProd_Outline(String prod_Outline) {
		this.prod_Outline = prod_Outline;
	}


	public String getProd_Detail() {
		return prod_Detail;
	}


	public void setProd_Detail(String prod_Detail) {
		this.prod_Detail = prod_Detail;
	}
	
	
	
}

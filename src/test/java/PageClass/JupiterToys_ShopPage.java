package PageClass;

import AbhinavA.Coding.PlanitAssesment.CommonFunctions;

public class JupiterToys_ShopPage extends CommonFunctions {
	
	public static final String subtotalColumn = "xpath=//table[@class='table table-striped cart-items']//tr//td[4]";
	public static final String cart_Link = "xpath=//a[contains(text(),'Cart')]";
	public static final String totalAmount = "xpath=//tfoot//strong[contains(text(),'Total:')]";
	public static final String startShopping_Link="partialLinkText=Start Shopping";
	
	public static String buy(String item) {
		return "xpath=//h4[text()='"+item+"']/..//following-sibling::p/a[text()='Buy']";
	}
	public static String productPriceShop(String item) {
		return "xpath=//h4[text()='"+item+"']/..//following-sibling::p/span";
	}
	public static String cartProductQuantity(String item) {
		return "xpath=//table[@class='table table-striped cart-items']//tr//td[contains(text(),'"+item+"')]//following-sibling::td[2]/input";
	}
	
	public static String cartProductSubtotal(String item) {
		return "xpath=//table[@class='table table-striped cart-items']//tr//td[contains(text(),'"+item+"')]//following-sibling::td[3]";
	}
	
	public static String productPriceCart(String item) {
		return "xpath=//table[@class='table table-striped cart-items']//tr//td[contains(text(),'"+item+"')]//following-sibling::td[1]";
	}



	

}

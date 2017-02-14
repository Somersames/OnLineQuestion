package szh.wechat.util;

public class PageBean {
	public static String page(String targetUrl, int total, int offset,
			int currentPage,String param) {
		// 分页的页数
		int totalPage = total % offset == 0 ? total / offset : total / offset+ 1;
		StringBuffer sb = new StringBuffer();
		sb.delete(0, sb.length());
		if (totalPage == 0) {
			return "没有查询到数据";
		} else 
		{
			StringBuffer pageCode = new StringBuffer();
			if(currentPage > 1) {
				pageCode.append("<li><a href='" + targetUrl + "?page=1&" + param + "'>首页</a></li>");
				pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage-1) + "&" + param + "'>上一页</a></li>");			
			}else{
				pageCode.append("<li class='disabled'><a>首页</a></li>");
				pageCode.append("<li class='disabled'><a>上一页</a></li>");		
			}
			for(int i = currentPage - 2; i <= currentPage + 2; i++) {
				if(i < 1 || i > totalPage) {
					continue;
				}
				if(i == currentPage) {
					pageCode.append("<li class='active'><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");	
				}else{
					pageCode.append("<li><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");	
				}
			}
			if(currentPage < totalPage) {
				pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage+1) + "&" + param + "'>下一页</a></li>");
				pageCode.append("<li><a href='" + targetUrl + "?page=" + totalPage + "&" + param + "'>尾页</a></li>");
			}else{
				pageCode.append("<li class='disabled'><a>下一页</a></li>");	
				pageCode.append("<li class='disabled'><a>尾页</a></li>");
			}
			return pageCode.toString();
		}
	}
}
//		{
//			if (currentpage > 1) {
//				sb.append("<li><a href=" + targeturl + "?page=1></a>首页<li>");
//				sb.append("<li><a href=" + targeturl + "?page="
//						+ (currentpage - 1) + ">上一页</a></li>");
//			} else {
//				sb.append("<li class='disabled'><a>首页</a>");
//				sb.append("<li><a href=" + targeturl + "?page="
//						+ (currentpage + 1) + ">下一页</a></li>");
//			}
//			for (int i = 1; i < currentpage+2; i++) {
//				if (i == currentpage) {
//					sb.append("<li class='active'><a href=" + targeturl+ "?page=" + i + ">" + i + "</a></li>");
//				} else {
//					sb.append("<li><a href=" + targeturl + "?page=" + i + ">"+ i + "</a></li>");
//				}
//			}
//			sb.append("<li><a href="+targeturl+"?page="+totalpage+">"+totalpage+"</a></li>");
//			return sb.toString();
//		}
//	}


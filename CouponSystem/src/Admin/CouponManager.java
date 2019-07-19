//package Admin;
//
//import Company.CompanyFacade;
//import Coupon.CouponFacade;
//import Customer.CustomerFacade;
//import Enums.ClientType;
//
//public class CouponManager {
//
//
//		private DailyCleaningTask dailyClean;
//		private static CouponManager instance = null;
//
//		private CouponManager() {
//			new Thread((Runnable) dailyClean).start();
//		}
//		public DailyCleaningTask getDailyTask() {
//			return dailyClean;
//		}
//
//		public void setDailyTask(DailyCleaningTask dailyTask) {
//			this.dailyClean = dailyTask;
//		}
//
//		public static CouponManager getInstance() {
//			if (instance == null) {
//				synchronized (CouponManager.class) {
//					if (instance == null) {
//						instance = new CouponManager();
//					}
//				}
//			}
//			return instance;
//		}
//		
//}}
//		public AdminFacade login(String name, String password,
//				ClientType clientType) throws Exception {
//		
//			AdminFacade adminfacade = new AdminFacade();
//			CompanyFacade companyfacade = new CompanyFacade();
//		//	CustomerFacade customerfacade = new CustomerFacade();
//
////			switch (clientType) {
////			case ADMIN:
////				adminfacade = (AdminFacade) adminfacade.login(name, password);
////				return adminfacade;
////
////			case COMPANY:
////				companyfacade = (CompanyFacade) companyfacade.Login(name, password);
////				return companyfacade;
////
////			case CUSTOMER:
////				customerfacade = (CustomerFacade) customerfacade.Login(name, password);
////				return customerfacade;
////
////			default:
////				return null;
//
//			//}
//		//}
//		
////		public void shutdown() {
////			dailyClean.setActive(false);
////			ConnectionPool.getInstance().closeAllConnections();
////		}
////	}
////
////}

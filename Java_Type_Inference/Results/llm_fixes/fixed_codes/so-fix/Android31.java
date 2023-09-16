package androidExamples;

public class Android31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
	}

	private static PowerManager getSystemService(String powerService) {
		// TODO Auto-generated method stub
		return null;
	}

	private static class PowerManager {
		public static final int FULL_WAKE_LOCK = 1;

		private PowerManager() {
			// private constructor
		}

		public WakeLock newWakeLock(int levelAndFlags, String tag) {
			return new WakeLock();
		}

		public class WakeLock {
			// empty class
		}
	}

	private static class Context {
		public static final String POWER_SERVICE = "power";

		private Context() {
			// private constructor
		}
	}
}
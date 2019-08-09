package src.单例模式;

    public class HolderDemo {
        private HolderDemo() {
        }

        private static class Holder {
            private static HolderDemo Instance = new HolderDemo();
        }// 实现了懒加载
        //没有使用synchronized
        //< init>
        public static HolderDemo getInstance() {
            return Holder.Instance;
        }


    }

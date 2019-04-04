
//using Farfetch.wishlist.Domain.Model;
//using System.Collections.Generic;

//namespace Farfetch.wishlist.Data.Repository.DummyData
//{
//    public class DummyDataRepository
//    {

//        public int ExternalId { get; set; }
//        public int OwnerId { get; set; }
//        private List<WishlistItem> Items { get; set; }



//        private static   List<Wishlist> wishlistList = null;
//        private Wishlist wl1 = new Wishlist { ExternalId = 1, OwnerId = 20, Items = null };

//        private WishlistItem item1 = new WishlistItem { Code = 100, Name = "namea", Price = 200, WishlistItemId = 1 };
//        private Wishlist wl2 = new Wishlist { ExternalId = 2, OwnerId = 20, Items = null };

//        private List<WishlistItem> items = new List<WishlistItem>();

   

//        public DummyDataRepository()
//        {

//        }


//        // Lock synchronization object

//        private static object syncLock = new object();

//        // Constructor (protected)
//        //private DummyDataRepository()
//        //{
//        //    items.Add(item1);
//        //    wishlistList.Add(wl1);
//        //    // wl2.Items.Add(item1);
//        //    wishlistList.Add(wl2);
//        //    // wishlistList.Add(new Wishlist { ExternalId = 2, OwnerId = 20, Items = new List<WishlistItem> { new WishlistItem { Code = 300, Name = "namec", Price = 200, WishlistItemId = 3 }, new WishlistItem { Code = 400, Name = "named", Price = 200, WishlistItemId = 4 } } });
//        //}



//        //create an object of SingleObject
        



//        //Get the only object available
//        public static IEnumerable<Wishlist> GetInstance()
//        {
//            {
                
//                if (wishlistList == null)
//                {
                    
                   
                       
//                             GetWishlistList();
//                             //_instance.GetWishlistList();
                           
                   

//                }

//                return wishlistList;
//            }
//        }

//        //pretende-se que só aconteça uma vez




//        private  static  void GetWishlistList()
//        {
//            wishlistList = (new List<Wishlist> { new Wishlist { ExternalId = 1, OwnerId = 10,  Items =  new List<WishlistItem> { new WishlistItem { Code = 100, Name = "namea", Price = 200, WishlistItemId = 1 } , new WishlistItem { Code = 200, Name = "nameb", Price = 200, WishlistItemId = 2 } } },
//                                                             new Wishlist { ExternalId = 2, OwnerId = 20, Items =  new List<WishlistItem> { new WishlistItem { Code = 300, Name = "namec", Price = 200, WishlistItemId = 3} , new WishlistItem { Code = 400, Name = "named", Price = 200, WishlistItemId = 4} } },
//                                                             new Wishlist { ExternalId = 3, OwnerId = 20, Items = null }});
            
//        }
//        //public static Wishlist GetWishlists()
//        //{

//        //d = 10,  Items =  new List<WishlistItem> { new WishlistItem { Code = 100, Name = "namea", Price = 200, WishlistItemId = 1 } , new WishlistItem { Code = 200, Name = "nameb", Price = 200, WishlistItemId = 2 } } },
//        //                                             new Wishlist { ExternalId = 2, OwnerId = 20, Items =  new List<WishlistItem> { new WishlistItem { Code = 300, Name = "namec", Price = 200, WishlistItemId = 3} , new WishlistItem { Code = 400, Name = "named", Price = 200, WishlistItemId = 4} } },
//        //                                             new Wishlist { ExternalId = 3, OwnerId = 20, Items = null }};
//        //}

//        //        private static readonly Lazy<DummyDataRepository>
//        //   lazy = new Lazy<DummyDataRepository>
//        //(() => new DummyDataRepository(new List<Wishlist> { new Wishlist { ExternalId = 1, OwnerId = 10,  Items =  new List<WishlistItem> { new WishlistItem { Code = 100, Name = "namea", Price = 200, WishlistItemId = 1 } , new WishlistItem { Code = 200, Name = "nameb", Price = 200, WishlistItemId = 2 } } },
//        //                                                     new Wishlist { ExternalId = 2, OwnerId = 20, Items =  new List<WishlistItem> { new WishlistItem { Code = 300, Name = "namec", Price = 200, WishlistItemId = 3} , new WishlistItem { Code = 400, Name = "named", Price = 200, WishlistItemId = 4} } },
//        //                                                     new Wishlist { ExternalId = 3, OwnerId = 20, Items = null }}
//        //));

//        // public static DummyDataRepository Instance { get { return SingletonHolder.instance; } }





//        //public void DoSomeStuff()
//        //{

//        //}

//    }
//}


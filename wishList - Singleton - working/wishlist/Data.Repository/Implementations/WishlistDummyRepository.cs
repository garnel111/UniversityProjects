using Farfetch.wishlist.Domain.Core.Interface;
using Farfetch.wishlist.Domain.Model;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;

namespace Farfetch.wishlist.Data.Repository.Implementations
{
    public class WishlistDummyRepository : IWishlistRepository
    {


        /*
         * DummyDatarepository
         * 
         */

        public int ExternalId { get; set; }
        public int OwnerId { get; set; }
        private List<WishlistItem> Items { get; set; }



        private static List<Wishlist> wishlistList = null;
        private Wishlist wl1 = new Wishlist { ExternalId = 1, OwnerId = 20, Items = null };

        private WishlistItem item1 = new WishlistItem { Code = 100, Name = "namea", Price = 200, WishlistItemId = 1 };
        private Wishlist wl2 = new Wishlist { ExternalId = 2, OwnerId = 20, Items = null };

        private List<WishlistItem> items = new List<WishlistItem>();







        //Get the only object available
        public static List<Wishlist> GetInstance()
        {
            {

                if (wishlistList == null)
                {

                    GetWishlistListA();
                    //_instance.GetWishlistList();

                }

                return wishlistList;
            }
        }


        private static void GetWishlistListA()
        {
            wishlistList = (new List<Wishlist> { new Wishlist { ExternalId = 1, OwnerId = 10,  Items =  new List<WishlistItem> { new WishlistItem { Code = 100, Name = "namea", Price = 200, WishlistItemId = 1 } , new WishlistItem { Code = 200, Name = "nameb", Price = 200, WishlistItemId = 2 } } },
                                                             new Wishlist { ExternalId = 2, OwnerId = 20, Items =  new List<WishlistItem> { new WishlistItem { Code = 300, Name = "namec", Price = 200, WishlistItemId = 3} , new WishlistItem { Code = 400, Name = "named", Price = 200, WishlistItemId = 4} } },
                                                             new Wishlist { ExternalId = 3, OwnerId = 20, Items = null }});

        }

        public Wishlist GetWishlist(int id)
        {

            List<Wishlist> wl1 = wishlistList.ToList();
            if (wl1.Any(item1 => item1.ExternalId == id))
            {
                return wl1.Find(wl => wl.ExternalId == id);
            }

            return null;

        }


        //ok
        public bool AddItem(int WishlistId, WishlistItem WishlistItem)
        {
            var WishlistResult = GetWishlist(WishlistId);
            if (WishlistResult != null && WishlistItem != null)
            {
                if (!WishlistResult.Items.Any(item1 => item1.WishlistItemId == WishlistItem.WishlistItemId))
                {
                    WishlistResult.Items.Add(WishlistItem);
                    return true;
                }
            }
            return false;

        }

        public bool AddWishlist(int id)
        {
            throw new NotImplementedException();
        }

        //ok
        public bool DeleteItem(int WishlistId, WishlistItem WishlistItem)
        {
            var WishlistResult = GetWishlist(WishlistId);
            if (WishlistResult != null && WishlistItem != null)
            {
                if (WishlistResult.Items.Any(item1 => item1.WishlistItemId == WishlistItem.WishlistItemId))
                {
                    WishlistResult.Items.Remove(WishlistItem);
                    return true;
                }
            }
            return false;
        }


        //not ok

        public bool UpdateItem(int WishlistId, WishlistItem WishlistItem)
        {
            var WishlistResult = GetWishlist(WishlistId);
            if (WishlistResult != null && WishlistItem != null)
            {
                if (WishlistResult.Items.Any(itemOnWishlist => itemOnWishlist.WishlistItemId == WishlistItem.WishlistItemId))
                {

                    int index = WishlistResult.Items.FindIndex(itemOnWishlist => itemOnWishlist.WishlistItemId == WishlistItem.WishlistItemId);
                    WishlistResult.Items.RemoveAt(index);
                    WishlistResult.Items.Add(WishlistItem);
                    return true;

                }

            }

            return false;
        }
        //public bool UpdateWishlist(int itemId, Wishlist Wishlist)
        //{
        //    var WishlistResult = GetAll(WishlistId);
        //    if (WishlistResult != null && WishlistItem != null)
        //    {
        //        if (WishlistResult.Items.Any(itemOnWishlist => itemOnWishlist.WishlistItemId == WishlistItem.WishlistItemId))
        //        {

        //            int index = WishlistResult.Items.FindIndex(itemOnWishlist => itemOnWishlist.WishlistItemId == WishlistItem.WishlistItemId);
        //            WishlistResult.Items.RemoveAt(index);
        //            WishlistResult.Items.Add(WishlistItem);
        //            return true;

        //        }

        //    }
        //}



        public WishlistItem getItem(List<WishlistItem> itemFoundList)
        {
            WishlistItem[] itemList = itemFoundList.ToArray();
            if (itemList.Length == 1)
            {
                return itemList[0];
            }
            return null;
        }

        private List<WishlistItem> RetrieveItem(WishlistItem item, Wishlist WishlistResult)
        {
            return (from it in WishlistResult.Items
                    where (it.WishlistItemId.Equals(item.WishlistItemId))
                    select it).ToList();

        }

        public IEnumerable<Wishlist> GetWishlistList()
        {

            return null;

        }

        //public void GetWishlistListwithSingleton()
        //{

        //    DummyData.DummyDataRepository dummyDataRepository = DummyData.DummyDataRepository.getInstance();
        //    dummyDataRepository.GetWishlists();
        //}


        public override string ToString()
        {
            foreach (var item in wishlistList)
            {
                Console.WriteLine("WishlistrepositoryItems: " + item.ToString());

            }
            return null;
        }





        public IEnumerable<Wishlist> GetAll()
        {

            var wlList = GetInstance();
            foreach (var item in wlList)
            {
                yield return item;
            }
            yield return null;
        }

        public Wishlist GetWishlistFromDataBase(int id)
        {
            var wlList = GetWishlistList();
            foreach (var item in wlList)
            {
                return item;
            }
            return null;
        }

        public Wishlist AddWishlist(Wishlist wl)
        {
            // var wishlistResult = GetAll();
            var wishlistResult = GetInstance();
            List<Wishlist> wlList = wishlistResult.ToList();
            Wishlist itemToRemove = null;

            if (wlList != null && wl != null)
            {
                if (wlList.Any(itemOnWishlist => itemOnWishlist.ExternalId == wl.ExternalId))
                {
                    itemToRemove = wlList.Where(itemOnWishlist => itemOnWishlist.ExternalId == wl.ExternalId).FirstOrDefault();
                }

                return itemToRemove;
            }

            return null;
        }

        IEnumerable<Wishlist> IWishlistRepository.GetWishlist(int id)
        {
            var wishlistList = GetInstance().ToList();
            // List<Wishlist> wishlistList1 = this.wishlistList.ToList();
            if (wishlistList.Any(item1 => item1.ExternalId == id))
            {
                yield return wishlistList.Find(wl => wl.ExternalId == id);
            }



        }

        //IEnumerable<Wishlist> IWishlistRepository.GetAll()
        //{
        //    var wlList = GetWishlistList();
        //    foreach (var item in wlList)
        //    {
        //        yield return item;
        //    }
        //    yield return null;
        //}
        IEnumerable<Wishlist> IWishlistRepository.GetAll()
        {


            wishlistList = GetInstance();
            //var wishlist =  Mapper.Map<IEnumerable<Farfetch.wishlist.Data.Repository.Models.Wishlist>, IEnumerable<Farfetch.wishlist.Domain.Model.Wishlist>>(result);

            return wishlistList;
        }

        Wishlist IWishlistRepository.AddWishlist(Wishlist wl)
        {
            var wishlistList = GetInstance();
            List<Wishlist> wlList = wishlistList.ToList();

            //if (wlList != null && wl != null)
            //{
            //    if (wlList.Any(itemOnWishlist => itemOnWishlist.ExternalId == wl.ExternalId))
            //    {
            //        itemToRemove = wlList.Where(itemOnWishlist => itemOnWishlist.ExternalId == wl.ExternalId).FirstOrDefault();
            //    }

            //    wlList.Remove(itemToRemove);
            wlList.Add(wl);


            // }
            wishlistList.Add(wl);
            return wl;

        }

        public Wishlist DeleteWishlist(Wishlist wlToRemove)
        {
            var wishlistList = GetInstance();
            List<Wishlist> wlList = wishlistList.ToList();
            // List<Wishlist> wlCloned = wlList;

            Wishlist itemToRemove = null;

            if (wlList != null && wlToRemove != null)
            {
                if (wlList.Any(itemOnWishlist => itemOnWishlist.ExternalId == wlToRemove.ExternalId))
                {
                    itemToRemove = wlList.Where(itemOnWishlist => itemOnWishlist.ExternalId == wlToRemove.ExternalId).FirstOrDefault();
                }

                wlList.Remove(itemToRemove);


            }
            wishlistList.Remove(wlToRemove);
            return wlToRemove;
        }

        public void UpdateWishlist(Wishlist wlToUpdate)
        {
            var wishlistList = GetInstance();
            List<Wishlist> wlList = wishlistList.ToList();
            // List<Wishlist> wlCloned = wlList;

            Wishlist itemToRemove = null;

            if (wlList != null && wlToUpdate != null)
            {
                if (wlList.Any(itemOnWishlist => itemOnWishlist.ExternalId == wlToUpdate.ExternalId))
                {
                    itemToRemove = wlList.Where(itemOnWishlist => itemOnWishlist.ExternalId == wlToUpdate.ExternalId).FirstOrDefault();
                }

                wlList.Remove(itemToRemove);


            }
            wishlistList.Remove(itemToRemove);
            wishlistList.Add(wlToUpdate);
        }

        public bool UpdateWishlist(int itemId, Wishlist Wishlist)
        {
            throw new NotImplementedException();
        }






        //public IEnumerable<wishlist> Get()
        //{
        //   return GetAll();
        //}



        //IEnumerable<Wishlist> GetAll(int id)
        // {
        //     var query = WishlistQueries.GetWishlistById;
        //     var param = new DynamicParameters();
        //     param.Add("@WishlistId", id);
        //     using (var conn = this.connectionFactory.GetConnection)
        //     {
        //         var result = conn.Query<Farfetch.wishlist.Data.Repository.Models.Wishlist>(query, param);

        //         var wishlist = TypeAdapterHelper.Adapt<IEnumerable<Farfetch.wishlist.Domain.Model.Wishlist>>(result);
        //        return wishlist;
        //     }
        // }



        //working method
        //IEnumerable<WishlistDTO> IWishlistRepository.GetAll(int id)
        //{
        //    var query = WishlistQueries.GetWishlistById;
        //    var param = new DynamicParameters();
        //    param.Add("@ExternalId", id);
        //    using (var conn = this.connectionFactory.GetConnection)
        //    {
        //        var result = conn.Query<Farfetch.wishlist.Data.Repository.Models.Wishlist>(query, param);
        //        var wishList = Mapper.Map<IEnumerable<Farfetch.wishlist.Data.Repository.Models.Wishlist>, IEnumerable<WishlistDTO>>(result);
        //        //var wishlist = TypeAdapterHelper.Adapt<Farfetch.wishlist.Domain.Model.Wishlist>(result);
        //        return wishList;
        //    }
        //}

        //public bool AddWishlist(Wishlist wl)
        //{

        //    if (wl != null && wl.ExternalId != 0)
        //    {

        //        var query = WishlistQueries.AddWishlist;
        //        var param = new DynamicParameters();
        //        param.Add("@ExternalId", wl.ExternalId);
        //        param.Add("@OwnerId", wl.OwnerId);

        //        using (var conn = this.connectionFactory.GetConnection)
        //        {
        //            var result = conn.Query<Farfetch.wishlist.Data.Repository.Models.Wishlist>(query, param);
        //            // var wishList = Mapper.Map<IEnumerable<Farfetch.wishlist.Data.Repository.Models.Wishlist>, IEnumerable<WishlistDTO>>(result);
        //            //var wishlist = TypeAdapterHelper.Adapt<Farfetch.wishlist.Domain.Model.Wishlist>(result);
        //            return true;
        //        }


        //    }
        //    return false;
        //}

    }

}





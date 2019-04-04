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
        public List<Wishlist> wishlistList;

        public Wishlist teste1 = new Wishlist { ExternalId = 3, OwnerId = 20, Items = null };
        private readonly IConnectionFactory connectionFactory;

        public int ExternalId { get; set; }
        public int OwnerId { get; set; }
        public List<WishlistItem> Items { get; set; }
        public interface IConnectionFactory
        {
            IDbConnection GetConnection { get; }
        }



        //ok
        public WishlistDummyRepository()
        {
            this.wishlistList = new List<Wishlist> { new Wishlist { ExternalId = 1, OwnerId = 10,  Items =  new List<WishlistItem> { new WishlistItem { Code = 100, Name = "namea", Price = 200, WishlistItemId = 1 } , new WishlistItem { Code = 200, Name = "nameb", Price = 200, WishlistItemId = 2 } } },
                                                     new Wishlist { ExternalId = 2, OwnerId = 20, Items =  new List<WishlistItem> { new WishlistItem { Code = 300, Name = "namec", Price = 200, WishlistItemId = 3} , new WishlistItem { Code = 400, Name = "named", Price = 200, WishlistItemId = 4} } },
                                                     new Wishlist { ExternalId = 3, OwnerId = 20, Items = null }};

        }

        //public WishlistDummyRepository(IWishlistItemRepository WishlistItemRepository)
        //{
        //    this.WishlistItem = new WishlistItemRepository();
        //}

        //  public WishlistRepository(DbContext dbContext1, WishlistItemRepository WishlistItemRepository) : base(dbContext1, null)
        //{
        //    this.dbContext = dbContext1;
        //    this.WishlistItemRepository = WishlistItemRepository;
        //}


        public Wishlist GetWishlist(int id)
        {

            if (this.wishlistList.Any(item1 => item1.ExternalId == id))
            {
                return this.wishlistList.Find(wl => wl.ExternalId == id);
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
        public bool UpdateWishlist(int itemId, Wishlist Wishlist)
        {
            throw new NotImplementedException();
        }



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
            return this.wishlistList;
        }


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

            var wlList = GetWishlistList();
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
            var wishlistResult = GetAll();
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

            if (this.wishlistList.Any(item1 => item1.ExternalId == id))
            {
                yield return this.wishlistList.Find(wl => wl.ExternalId == id);
            }



        }

        IEnumerable<Wishlist> IWishlistRepository.GetAll()
        {
            var wlList = GetWishlistList();
            foreach (var item in wlList)
            {
                yield return item;
            }

        }

        Wishlist IWishlistRepository.AddWishlist(Wishlist wl)
        {
            wishlistList.Add(wl);
            return wl;

        }






        //public IEnumerable<wishlist> Get()
        //{
        //   return GetAll();
        //}
        //public async Task<Wishlist> GetAll(int WishlistId)
        //{
        //    string query = WishlistQueries.GetWishlistById;
        //    //realizar mapeamento com dapper

        //    var param = new DynamicParameters();
        //    param.Add("@WishlistId", WishlistId);

        //    using (var conn = this.connectionFactory.GetConnection)
        //    {
        //        //var result = await conn.QueryFirstOrDefaultAsync<DataRepository.ReturnOrder>(query, param).ConfigureAwait(false);
        //        //var returnOrder = TypeAdapterHelper.Adapt<DomainModel.ReturnOrder>(result);
        //        //return returnOrder;
        //    }
        //    return null;
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

using AutoMapper;
using Dapper;
using Farfetch.wishlist.Data.Repository.Models.SqlQueries;
using Farfetch.wishlist.Domain.Core.Interface;
using Farfetch.wishlist.Domain.Model;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
//using Farfetch.wishlist.Infrastructure.CrossCutting.Adapters;


namespace Farfetch.wishlist.Data.Repository
{
    public class WishlistRepository : IWishlistRepository

    {
        public List<Wishlist> WishlistList;

        public Wishlist teste1 = new Wishlist { ExternalId = 3, OwnerId = 20, Items = null };
        private readonly IConnectionFactory connectionFactory;

        private IWishlistItemRepository wishlistItemRepository;
        //private Mock<DbContext> dbContext1;
        //private DbContext dbContext;

        List<WishlistItem> WishlistItemList = new List<WishlistItem> { new WishlistItem { Code = 100, Name = "NameA", Price = 200, WishlistItemId = 1 } };

        //tentativa ligar à base de dados


        public WishlistRepository(IConnectionFactory connectionFactory)
        {
            this.connectionFactory = connectionFactory;
            // this.wishlistItemRepository = new WishlistItemRepository();
        }

        //public WishlistRepository()
        //{

        //}

        //public WishlistRepository(IConnectionFactory connectionFactory)
        //{
        //    this.connectionFactory = connectionFactory;
        //}
        //ok
        //public WishlistRepository()
        //{
        //    this.WishlistList = new List<wishlist> { new wishlist { ExternalId = 1, OwnerId = 10,  Items =  new List<WishlistItem> { new WishlistItem { Code = 100, Name = "namea", Price = 200, WishlistItemId = 1 } , new WishlistItem { Code = 200, Name = "nameb", Price = 200, WishlistItemId = 2 } } },
        //                                             new wishlist { ExternalId = 2, OwnerId = 20, Items =  new List<WishlistItem> { new WishlistItem { Code = 300, Name = "namec", Price = 200, WishlistItemId = 3} , new WishlistItem { Code = 400, Name = "named", Price = 200, WishlistItemId = 4} } },
        //                                             new wishlist { ExternalId = 3, OwnerId = 20, Items = null }};

        //}

        //public WishlistRepository(IWishlistItemRepository WishlistItemRepository)
        //{
        //    this.wishlistItemRepository = new WishlistItemRepository();
        //}

        //  public WishlistRepository(DbContext dbContext1, WishlistItemRepository WishlistItemRepository) : base(dbContext1, null)
        //{
        //    this.dbContext = dbContext1;
        //    this.WishlistItemRepository = WishlistItemRepository;
        //}


        //public Wishlist GetWishlist(int id)
        //{

        //    if (this.WishlistList.Any(item1 => item1.ExternalId == id))
        //    {
        //        return this.WishlistList.Find(wl => wl.ExternalId == id);
        //    }

        //    return null;

        //}

        IEnumerable<Wishlist> GetWishlistFromDataBase(int id)
        {
            var query = WishlistQueries.GetWishlistById;
            var param = new DynamicParameters();
            param.Add("@WishlistId", id);
            using (var conn = this.connectionFactory.GetConnection)
            {
                var result = conn.Query<Farfetch.wishlist.Data.Repository.Models.Wishlist>(query, param);
                //   var wishlist = Mapper.Map
                //var wishlist = TypeAdapterHelper.Adapt<IEnumerable<Farfetch.wishlist.Domain.Model.Wishlist>>(result);
                var wishlist = Mapper.Map<IEnumerable<Farfetch.wishlist.Data.Repository.Models.Wishlist>, IEnumerable<Wishlist>>(result);
                return wishlist;
            }
        }


        //ok
        public bool AddItem(int WishlistId, WishlistItem WishlistItem)
        {
            //    var WishlistResult = GetAll(WishlistId);
            //    if (WishlistResult != null && WishlistItem != null)
            //    {
            //        if (!WishlistResult.Items.Any(item1 => item1.WishlistItemId == WishlistItem.WishlistItemId))
            //        {
            //            WishlistResult.Items.Add(WishlistItem);
            //            return true;
            //        }
            //  }
            return false;

        }

        public bool AddWishlist(int id)
        {
            throw new NotImplementedException();
        }

        //ok
        public bool DeleteItem(int WishlistId, WishlistItem WishlistItem)
        {
            //var WishlistResult = GetAll(WishlistId);
            //if (WishlistResult != null && WishlistItem != null)
            //{
            //    if (WishlistResult.Items.Any(item1 => item1.WishlistItemId == WishlistItem.WishlistItemId))
            //    {
            //        WishlistResult.Items.Remove(WishlistItem);
            //        return true;
            //    }
            //}
            return false;
        }


        //not ok

        public bool UpdateItem(int WishlistId, WishlistItem WishlistItem)
        {
            //var WishlistResult = GetAll(WishlistId);
            //if (WishlistResult != null && WishlistItem != null)
            //{
            //    if (WishlistResult.Items.Any(itemOnWishlist => itemOnWishlist.WishlistItemId == WishlistItem.WishlistItemId))
            //    {

            //        int index = WishlistResult.Items.FindIndex(itemOnWishlist => itemOnWishlist.WishlistItemId == WishlistItem.WishlistItemId);
            //        WishlistResult.Items.RemoveAt(index);
            //        WishlistResult.Items.Add(WishlistItem);
            //        return true;

            //    }

            //}

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
            return this.WishlistList;
        }


        public override string ToString()
        {
            foreach (var item in WishlistList)
            {
                Console.WriteLine("WishlistrepositoryItems: " + item.ToString());

            }
            return null;
        }

        //IEnumerable<Wishlist> IWishlistRepository.GetAll()
        //{
        //    var query = WishlistQueries.GetWishlistList;
        //    var param = new DynamicParameters();
        //    // param.Add("@ExternalId", id);
        //    using (var conn = this.connectionFactory.GetConnection)
        //    {
        //        var result = conn.Query<List<Farfetch.wishlist.Data.Repository.Models.Wishlist>>(query, param);

        //        var wishList = TypeAdapterHelper.Adapt<IEnumerable<Farfetch.wishlist.Domain.Model.Wishlist>>(result);
        //        return wishList;
        //    };
        //}

        //public Wishlist GetWishlist()
        //{

        //    var wlList = GetWishlistList();
        //    foreach (var item in wlList)
        //    {
        //        return item;
        //    }
        //    return null;
        //}

        //public IEnumerable<wishlist> Get()
        //{
        //   return GetAll();
        //}



        //IEnumerable<Wishlist> GetAll()
        //{
        //    var query = WishlistQueries.GetWishlistList;
        //    var param = new DynamicParameters();
        //   // param.Add("@WishlistId", id);
        //    using (var conn = this.connectionFactory.GetConnection)
        //    {
        //        var result = conn.Query<Farfetch.wishlist.Data.Repository.Models.Wishlist>(query, param);

        //        var wishlist = TypeAdapterHelper.Adapt<IEnumerable<Farfetch.wishlist.Domain.Model.Wishlist>>(result);
        //        return wishlist;
        //    }
        //}



        //working method
        IEnumerable<Wishlist> GetWishlist(int id)
        {
            var query = WishlistQueries.GetWishlistById;
            var param = new DynamicParameters();
            param.Add("@ExternalId", id);
            using (var conn = this.connectionFactory.GetConnection)
            {
                var result = conn.Query<Farfetch.wishlist.Data.Repository.Models.Wishlist>(query, param);
                var wishList = Mapper.Map<IEnumerable<Farfetch.wishlist.Data.Repository.Models.Wishlist>, IEnumerable<Wishlist>>(result);
                // var wishList = TypeAdapterHelper.Adapt<IEnumerable<Farfetch.wishlist.Domain.Model.Wishlist>>(result);
                return wishList;
            }
        }

        //public IEnumerable<Wishlist> AddWishlist(Wishlist wl)
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
        //            var wishList = Mapper.Map<IEnumerable<Farfetch.wishlist.Data.Repository.Models.Wishlist>, IEnumerable<Wishlist>>(result);
        //            //var wishlist = TypeAdapterHelper.Adapt<Farfetch.wishlist.Domain.Model.Wishlist>(result);
        //            return wishList;
        //        }


        //    }
        //    return null;
        //}
          public  Wishlist AddWishlist(Wishlist wl)
        {

            if (wl != null && wl.ExternalId != 0)
            {

                var query = WishlistQueries.AddWishlist;
                var param = new DynamicParameters();
                param.Add("@ExternalId", wl.ExternalId);
                param.Add("@OwnerId", wl.OwnerId);

                using (var conn = this.connectionFactory.GetConnection)
                {
                    var result = conn.Query<Farfetch.wishlist.Data.Repository.Models.Wishlist>(query, param);
                    var wishList = Mapper.Map<Farfetch.wishlist.Data.Repository.Models.Wishlist, Wishlist>(result.First());
                    //var wishlist = TypeAdapterHelper.Adapt<Farfetch.wishlist.Domain.Model.Wishlist>(result);
                    return wishList;
                }


            }
            return null;
        }


        //Wishlist IWishlistRepository.GetWishlist(int id)
        //{
        //    var query = WishlistQueries.GetWishlistById;
        //    var param = new DynamicParameters();
        //    param.Add("@ExternalId", id);
        //    using (var conn = this.connectionFactory.GetConnection)
        //    {
        //        var result = conn.Query<Farfetch.wishlist.Data.Repository.Models.Wishlist>(query, param);
        //        var wishList = Mapper.Map<Farfetch.wishlist.Data.Repository.Models.Wishlist, Wishlist>(result);
        //        //var wishList = TypeAdapterHelper.Adapt<Farfetch.wishlist.Domain.Model.Wishlist>(result);
        //        yield return result;
        //    }
        //}

        //IEnumerable<Wishlist> IWishlistRepository.GetAll()
        //{
        //    var query = WishlistQueries.GetWishlistList;
        //    var param = new DynamicParameters();
        //    // param.Add("@WishlistId", id);
        //    using (var conn = this.connectionFactory.GetConnection)
        //    {
        //        var result = conn.Query<Farfetch.wishlist.Data.Repository.Models.Wishlist>(query, param);

        //        var wishlist = TypeAdapterHelper.Adapt<IEnumerable<Farfetch.wishlist.Domain.Model.Wishlist>>(result);
        //        return wishlist;
        //    }
        //}

        IEnumerable<Wishlist> IWishlistRepository.GetWishlist(int id)
        {
            var query = WishlistQueries.GetWishlistById;
            var param = new DynamicParameters();
            param.Add("@ExternalId", id);
            using (var conn = this.connectionFactory.GetConnection)
            {
                var result = conn.Query<Farfetch.wishlist.Data.Repository.Models.Wishlist>(query, param);

                var wishList = Mapper.Map<IEnumerable<Farfetch.wishlist.Data.Repository.Models.Wishlist>, IEnumerable<Farfetch.wishlist.Domain.Model.Wishlist>>(result);
                return wishList;
            }
        }

        public IEnumerable<Wishlist> GetAll()
        {
            {
                var query = WishlistQueries.GetWishlistList;
                var param = new DynamicParameters();
                // param.Add("@WishlistId", id);
                using (var conn = this.connectionFactory.GetConnection)
                {
                    var result = conn.Query<Farfetch.wishlist.Data.Repository.Models.Wishlist>(query, param);

                    var wishList = Mapper.Map<IEnumerable<Farfetch.wishlist.Data.Repository.Models.Wishlist>, IEnumerable<Farfetch.wishlist.Domain.Model.Wishlist>>(result);
                    return wishList;
                }
            }
        }

        public Wishlist DeleteWishlist(Wishlist wlToRemove)
        {
            throw new NotImplementedException();
        }

        public void UpdateWishlist(Wishlist wlToUpdate)
        {
            throw new NotImplementedException();
        }
    }



}














using Dapper;
using Farfetch.wishlist.Data.Repository.Models.SqlQueries;
using Farfetch.wishlist.Domain.Core.Interface;
using Farfetch.wishlist.Domain.Model;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;

namespace Farfetch.wishlist.Data.Repository
{
    public class WishlistRepository : IWishlistRepository

    {
        public List<Wishlist> wishlistList;
        public Wishlist teste1 = new Wishlist { ExternalId = 3, OwnerId = 20, Items = null };
        private readonly IConnectionFactory connectionFactory;

        // List<WishlistItem> wishlistItemList = new List<WishlistItem> { new WishlistItem { Code = 100, Name = "NameA", Price = 200, ExternalId = 1 } };

        //tentativa ligar à base de dados
        public interface IConnectionFactory
        {
            IDbConnection GetConnection { get; }
        }

        //public WishlistRepository()
        //{

        //}

        //public WishlistRepository(IConnectionFactory connectionFactory)
        //{
        //    this.connectionFactory = connectionFactory;
        //}
        //ok
        public WishlistRepository()
        {
            this.wishlistList = new List<Wishlist> { new Wishlist { ExternalId = 1, OwnerId = 10,  Items =  new List<WishlistItem> { new WishlistItem { Code = 100, Name = "namea", Price = 200, ExternalId = 1 } , new WishlistItem { Code = 200, Name = "nameb", Price = 200, ExternalId = 2 } } },
                                                     new Wishlist { ExternalId = 2, OwnerId = 20, Items =  new List<WishlistItem> { new WishlistItem { Code = 300, Name = "namec", Price = 200, ExternalId = 3} , new WishlistItem { Code = 400, Name = "named", Price = 200, ExternalId = 4} } },
                                                     new Wishlist { ExternalId = 3, OwnerId = 20, Items = null }};

        }


        public Wishlist GetWishlist(int id)
        {

            if (this.wishlistList.Any(item1 => item1.ExternalId == id))
            {
                return this.wishlistList.Find(wl => wl.ExternalId == id);
            }

            return null;

        }


        //ok
        public bool AddItem(int wishlistId, WishlistItem wishlistItem)
        {
            var wishlistResult = GetWishlist(wishlistId);
            if (wishlistResult != null && wishlistItem != null)
            {
                if (!wishlistResult.Items.Any(item1 => item1.ExternalId == wishlistItem.ExternalId))
                {
                    wishlistResult.Items.Add(wishlistItem);
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
        public bool DeleteItem(int wishlistId, WishlistItem wishlistItem)
        {
            var wishlistResult = GetWishlist(wishlistId);
            if (wishlistResult != null && wishlistItem != null)
            {
                if (wishlistResult.Items.Any(item1 => item1.ExternalId == wishlistItem.ExternalId))
                {
                    wishlistResult.Items.Remove(wishlistItem);
                    return true;
                }
            }
            return false;
        }


        //not ok

        public bool UpdateItem(int wishlistId, WishlistItem wishlistItem)
        {
            var wishlistResult = GetWishlist(wishlistId);
            if (wishlistResult != null && wishlistItem != null)
            {
                if (wishlistResult.Items.Any(itemOnWishlist => itemOnWishlist.ExternalId == wishlistItem.ExternalId))
                {

                    int index = wishlistResult.Items.FindIndex(itemOnWishlist => itemOnWishlist.ExternalId == wishlistItem.ExternalId);
                    wishlistResult.Items.RemoveAt(index);
                    wishlistResult.Items.Add(wishlistItem);
                    return true;

                }

            }

            return false;
        }
        public bool UpdateWishlist(int itemId, Wishlist wishlist)
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

        private List<WishlistItem> RetrieveItem(WishlistItem item, Wishlist wishlistResult)
        {
            return (from it in wishlistResult.Items
                    where (it.ExternalId.Equals(item.ExternalId))
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
                Console.WriteLine("wishlistrepositoryItems: " + item.ToString());

            }
            return null;
        }


        public async Task<Wishlist> GetWishlistFromDataBase(int wishlistId)
        {
            string query = WishlistQueries.GetWishlistById;
            //realizar mapeamento com dapper

            var param = new DynamicParameters();
            param.Add("@wishlistId", wishlistId);

            using (var conn = this.connectionFactory.GetConnection)
            {
                //var result = await conn.QueryFirstOrDefaultAsync<DataRepository.ReturnOrder>(query, param).ConfigureAwait(false);
                //var returnOrder = TypeAdapterHelper.Adapt<DomainModel.ReturnOrder>(result);
                //return returnOrder;
            }
            return null;
        }

    

        List<Wishlist> IWishlistRepository.GetWishlistList()
        {
            return wishlistList;
        }

        public Wishlist GetWishlist()
        {

            var wlList = GetWishlistList();
            foreach (var item in wlList)
            {
                return item;
            }
            return null;
        }



        //public Wishlist GetWishlist()
        //{
        //    return teste1;
        //}
    }




}














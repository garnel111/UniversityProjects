using Farfetch.wishlist.Domain.Model;
using System.Collections.Generic;

namespace Farfetch.wishlist.Domain.Core.Interface
{
    public interface IWishlistRepository 
    {

        List<Wishlist> GetWishlistList();
        Wishlist GetWishlist(int id);
        bool AddWishlist(int id);
        bool UpdateWishlist(int itemId, Wishlist wishlist);
        bool AddItem(int wishlistId, WishlistItem item);
        bool DeleteItem(int wishlistId, WishlistItem item);
        bool UpdateItem(int wishlistId, WishlistItem item);
        Wishlist GetWishlist();
        //Task<Wishlist> GetWishlist(int id);
        //Task<bool> AddWishlist(int id);

        ////Update Wishlist
        //Task<bool> UpdateWishlist(int itemId, Wishlist wishlist);

        //Task<bool> AddItem(int wishlistId, WishlistItem item);
        //Task<bool> DeleteItem(int wishlistId, WishlistItem item);
        //Task<bool> UpdateItem(int wishlistId, WishlistItem item);

    }
}

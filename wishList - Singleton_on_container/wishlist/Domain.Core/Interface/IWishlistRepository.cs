using Farfetch.wishlist.Domain.Model;
using System.Collections.Generic;

namespace Farfetch.wishlist.Domain.Core.Interface
{
    public interface IWishlistRepository
    {

        IEnumerable<Wishlist> GetAll();

        IEnumerable<Wishlist> GetWishlist(int id);

        Wishlist AddWishlist( Wishlist wl);
        bool UpdateWishlist(int itemId, Wishlist Wishlist);
        bool AddItem(int WishlistId, WishlistItem item);
        bool DeleteItem(int WishlistId, WishlistItem item);
        bool UpdateItem(int WishlistId, WishlistItem item);
        // Wishlist GetWishlist(int WishlistID);
        // IEnumerable<List<wishlist>> Get();
        //Task<wishlist> GetWishlist(int id);
        //Task<bool> AddWishlist(int id);

        ////Update wishlist
        //Task<bool> UpdateWishlist(int itemId, wishlist wishlist);

        //Task<bool> AddItem(int WishlistId, WishlistItem item);
        //Task<bool> DeleteItem(int WishlistId, WishlistItem item);
        //Task<bool> UpdateItem(int WishlistId, WishlistItem item);

    }
}

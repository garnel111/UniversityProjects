using Farfetch.wishlist.Application.DTO;
using Farfetch.wishlist.Domain.Model;
using System.Collections.Generic;

namespace Farfetch.wishlist.Application.Services.Interfaces
{
    public interface IWishlistService
    {
       // IEnumerable<Wishlist> AddOrUpdateWishlist(WishlistDTO WishlistDTO);
        Wishlist AddOrUpdateWishlist(WishlistDTO WishlistDTO);

      

        IEnumerable<WishlistDTO> GetWishlist(int WishlistID);

        void DeleteWishlist(int WishlistID);
        IEnumerable<WishlistDTO> GetAll();
        IEnumerable<WishlistDTO> GetWithSingleton();
        Wishlist DeleteWishlist(Wishlist wlToRemove);
        void UpdateWishlist(Wishlist wlToUpdate);
    }
}

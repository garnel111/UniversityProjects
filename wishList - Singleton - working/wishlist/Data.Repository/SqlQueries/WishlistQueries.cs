namespace Farfetch.wishlist.Data.Repository.Models.SqlQueries
{
    public class WishlistQueries
    {
        // 
        public static readonly string GetWishlistById = @"select *
        from Wishlist wl      
        where wl.ExternalId= @ExternalId";


        // add wihslist to database
        public static readonly string AddWishlist = @"INSERT INTO Wishlist (ExternalId, OwnerId)
                                                    VALUES (@ExternalId, @OwnerId )";

        public static readonly string GetWishlistList = @"select * from Wishlist wl";
    }
}

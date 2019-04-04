using System.Collections.Generic;

namespace Farfetch.wishlist.Domain.Model
{
   public  class Owner : AuditableDomainEntity
    {
        private Wishlist wlist;

        public int ExternalId { get; set; }
        
        public string Name { get; set; }
        public Owner()
        {

        }
        public Owner(int externalId, string name) :this()

        {
            
            this.ExternalId = externalId;
            this.Name = name;
            

        }
        public ICollection<Wishlist> wishlists { get; set; }
        public void AddWishlist(Wishlist wishlist)
        {
            
                wishlists.Add(wishlist);
     
        }

        //???????? dúvidas
       public Wishlist GetOrCreateWishlist(Wishlist wishlist)
        {
            if(wishlist == null)
            {
                 return wishlist = new Wishlist();    

            }

           return wishlist;
        }


        //método owner??
 
        public void RemoveWihsList(Wishlist wishlist)
        {
            wishlists.Remove(wishlist);
        }
    }
}

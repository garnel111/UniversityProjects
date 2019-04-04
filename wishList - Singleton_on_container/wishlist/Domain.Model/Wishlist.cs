using System.Collections.Generic;
using System.Linq;

namespace Farfetch.wishlist.Domain.Model
{
    public class Wishlist
    {

        public int ExternalId { get; set; }
        public int OwnerId { get; set; }
        public List<WishlistItem> Items { get; set; }
        public Wishlist(List<WishlistItem> Items)
        {
            this.Items = new List<WishlistItem>();
        }


        public Wishlist()
        {
            this.Items = new List<WishlistItem>();
        }
        public Wishlist(int ExternalId, int OwnerId, List<WishlistItem> Items)
        {
            this.ExternalId = ExternalId;
            this.OwnerId = OwnerId;
            this.Items = Items;
        }

        public void AddOrUpdateWishlistItem(WishlistItem item)
        {
            try
            {
                if (!Items.Any(item1 => item1.WishlistItemId == item.WishlistItemId))
                {
                    Items.Add(item);
                    return;
                }
                int id = item.WishlistItemId;

                var itemFoundList = RetrieveItem(item);

                var itemRetrieved = getItem(itemFoundList);

                if (itemRetrieved != null)
                {
                    Items.Remove(item);
                    Items.Add(itemRetrieved);
                }
            }
            catch (KeyNotFoundException)
            {

            }


        }

        private WishlistItem getItem(List<WishlistItem> itemFoundList)
        {
            WishlistItem[] itemList = itemFoundList.ToArray();
            if (itemList.Length == 1)
            {
                return itemList[0];
            }
            return null;
        }

        private List<WishlistItem> RetrieveItem(WishlistItem item)
        {
            return (from it in Items
                    where (it.WishlistItemId.Equals(item.WishlistItemId))
                    select it).ToList();

        }

        public override string ToString()
        {
            foreach (var item in Items)
            {
                System.Console.WriteLine(" item: " + item.ToString() + "\n item id: " + item.ExternalId.ToString() + "\n itemName: " + item.Name.ToString());
                //System.Console.WriteLine(item.Id.ToString());
                //System.Console.WriteLine(item.Name.ToString());

            }
            return null;
        }

        public override bool Equals(object obj)
        {
            var objCasted = (Wishlist)obj;
            return this.ExternalId == objCasted.ExternalId && this.OwnerId == objCasted.OwnerId;

        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public WishlistItem GetWishlistItemById(int v)
        {


            foreach (var item in Items)
            {
                try
                {
                    if (item.ExternalId == v)
                    {
                        return item;
                    }
                    else
                    {
                        throw new KeyNotFoundException();
                    }



                }
                catch (KeyNotFoundException knfe)
                {
                    System.Console.WriteLine(knfe);

                }


            }
            return null;
        }
    }

}


using Bag from './Bag';
using Id from './Bag';

		entity Address {
		    key adid : Id;
		    usid : String(4);
		    city : String(100);
		    strt : String(100);
		    hnum : Integer;
		};

		entity Laptops {
		    key crid : Id;
		    usid : String(4);
		    name : String(100);

    		toBag : association to one Bag on toBag.usid = usid;
		};

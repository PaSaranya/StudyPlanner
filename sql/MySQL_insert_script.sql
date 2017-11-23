-- Insert script ------------------------------------------
-- Inserts test/sample data into the database
USE `jstudyplanner`;

-- Empty all the tables before inserting data
DELETE FROM enrollment WHERE id != 0;
DELETE FROM course_availability WHERE id != 0;
DELETE FROM campus_management WHERE campus_fk != 0;
DELETE FROM user WHERE id != 1;
DELETE FROM major_compulsory_courses WHERE major_fk != 0;
DELETE FROM program_elective_courses WHERE program_fk != 0;
DELETE FROM major WHERE id != 0;
DELETE FROM program_core_courses WHERE program_fk != 0;
DELETE FROM program WHERE id != 0;
DELETE FROM prerequisite WHERE course != 0;
DELETE FROM course WHERE id != 0;
DELETE FROM campus WHERE id != 0;
DELETE FROM term WHERE id != 0;



-- Term -------------------------------------
INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (1, 2012, 1, STR_TO_DATE('20-02-2012', '%d-%m-%Y'), STR_TO_DATE('7-06-2012', '%d-%m-%Y'), 0);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (2, 2012, 2, STR_TO_DATE('2-07-2012', '%d-%m-%Y'), STR_TO_DATE('19-10-2012', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (3, 2012, 3, STR_TO_DATE('5-11-2012', '%d-%m-%Y'), STR_TO_DATE('18-01-2013', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (4, 2013, 1, STR_TO_DATE('25-02-2013', '%d-%m-%Y'), STR_TO_DATE('7-06-2013', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (5, 2013, 2, STR_TO_DATE('1-07-2013', '%d-%m-%Y'), STR_TO_DATE('18-10-2013', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (6, 2013, 3, STR_TO_DATE('9-11-2013', '%d-%m-%Y'), STR_TO_DATE('17-01-2014', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (7, 2014, 1, STR_TO_DATE('24-02-2014', '%d-%m-%Y'), STR_TO_DATE('6-06-2014', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (8, 2014, 2, STR_TO_DATE('7-07-2014', '%d-%m-%Y'), STR_TO_DATE('17-10-2014', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (9, 2014, 3, STR_TO_DATE('3-11-2014', '%d-%m-%Y'), STR_TO_DATE('16-01-2015', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (10, 2015, 1, STR_TO_DATE('23-02-2015', '%d-%m-%Y'), STR_TO_DATE('5-06-2015', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (11, 2015, 2, STR_TO_DATE('6-07-2015', '%d-%m-%Y'), STR_TO_DATE('16-10-2015', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (12, 2015, 3, STR_TO_DATE('2-11-2015', '%d-%m-%Y'), STR_TO_DATE('22-01-2016', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (13, 2016, 1, STR_TO_DATE('22-02-2016', '%d-%m-%Y'), STR_TO_DATE('3-06-2016', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (14, 2016, 2, STR_TO_DATE('4-07-2016', '%d-%m-%Y'), STR_TO_DATE('14-10-2016', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (15, 2016, 3, STR_TO_DATE('7-11-2016', '%d-%m-%Y'), STR_TO_DATE('20-01-2017', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (16, 2017, 1, STR_TO_DATE('20-02-2017', '%d-%m-%Y'), STR_TO_DATE('2-06-2017', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (17, 2017, 2, STR_TO_DATE('3-07-2017', '%d-%m-%Y'), STR_TO_DATE('13-10-2017', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (18, 2017, 3, STR_TO_DATE('6-11-2017', '%d-%m-%Y'), STR_TO_DATE('19-01-2018', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (19, 2018, 1, STR_TO_DATE('19-02-2018', '%d-%m-%Y'), STR_TO_DATE('1-06-2018', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (20, 2018, 2, STR_TO_DATE('2-07-2018', '%d-%m-%Y'), STR_TO_DATE('14-10-2018', '%d-%m-%Y'), 1);

INSERT INTO term (id, year, number, start_date, finish_date, enabled)
VALUES (21, 2018, 3, STR_TO_DATE('5-11-2018', '%d-%m-%Y'), STR_TO_DATE('18-01-2018', '%d-%m-%Y'), 1);





-- Campus -------------------------------------
INSERT INTO campus (id, code, title, enabled, address, phone, description)
VALUES (1, 'IPS', 'Ipswich', 1, '199 Church St', '+61 7 6218 9544',
'Nunc quis mauris viverra, scelerisque mauris vel, convallis ante. Curabitur tempus lacus diam. Duis viverra tempor lorem nec venenatis. Nunc ut fermentum libero, ut fermentum nibh. Proin ac ullamcorper justo. Praesent urna lacus, mattis ut massa ac, eleifend bibendum leo. Nunc fermentum aliquam mollis. Nullam cursus sem vitae mollis suscipit. Praesent fringilla aliquam nisl, ullamcorper semper est accumsan et. Maecenas tempor condimentum tortor. Nunc facilisis auctor risus id congue. Pellentesque sollicitudin dui ac magna rhoncus, at varius neque laoreet. Pellentesque sit amet fringilla mauris, vitae suscipit enim. Praesent fermentum dui vel enim hendrerit, imperdiet euismod dolor vulputate. Vestibulum sollicitudin, leo nec placerat tempus, libero dui volutpat lorem, vitae pretium ligula urna ac enim. Curabitur sed vestibulum elit, quis dapibus ipsum. Proin tristique porta elementum. Quisque varius mauris id tempor lacinia.In sollicitudin id mauris vitae hendrerit. Maecenas accumsan massa risus, id auctor ligula accumsan et. Cras facilisis gravida tortor. Phasellus et tristique sem. Suspendisse ullamcorper faucibus lorem quis tincidunt. Etiam rhoncus non elit eu mollis. Pellentesque justo enim, venenatis at est id, congue viverra libero. Maecenas eu sapien velit. Nullam vitae dui mauris.');

INSERT INTO campus (id, code, title, enabled, address, phone, description)
VALUES (2, 'NCL', 'Newcastle', 1, '694 Perry St', '751622148',
'The Newcastle metropolitan area is the second most populated area in the Australian state of New South Wales and includes most of the Newcastle and Lake Macquarie local government areas.

162 kilometres (101 mi) NNE of Sydney, at the mouth of the Hunter River, it is the predominant city within the Hunter Region. Famous for its coal, Newcastle is the largest coal exporting harbour in the world, exporting over 97 Mt of coal in 2009–10 with plans to expand annual capacity to 180 Mt by 2013.

Under Captain James Wallis, commandant from 1815 to 1818, the convicts conditions improved, and a building boom began. Captain Wallis laid out the streets of the town, built the first church of the site of the present Christ Church Anglican Cathedral, erected the old gaol on the seashore, and began work on the breakwater which now joins Nobbys Head to the mainland. The quality of these first buildings was poor, and only (a much reinforced) breakwater survives. During this period, in 1816, the oldest public school in Australia was built in East Newcastle.

After removal of the last convicts in 1823, the town was freed from the infamous influence of the penal law. It began to acquire the aspect of a typical Australian pioneer settlement, and a steady flow of free settlers poured into the hinterland. Because of the coal supply, small ships plied between Newcastle and Sydney, Brisbane, Melbourne and Adelaide, carrying coal to gas works and bunkers for shipping, and railways. These were commonly known as "sixty-milers", referring to the nautical journey between Newcastle and Sydney.');

INSERT INTO campus (id, code, title, enabled, address, phone, description)
VALUES (3, 'MCK', 'Mackay', 1, '485 Ann St', '7566181002',
'Mackay is a city on the eastern coast of Queensland, Australia, about 970 kilometres (603 mi) north of Brisbane, on the Pioneer River. Mackay is nicknamed the sugar capital of Australia because its region produces more than a third of Australias cane sugar. There is controversy about the geographic location of the region, with most people referring to it as a part of either Central Queensland or North Queensland, though much confusion still lies within the Queensland Government, with government services being provided through both Townsville (North Queensland) and Rockhampton (Central Queensland).

Mackay was battered by Tropical Cyclone Ului, a category three cyclone which crossed the coast at nearby Airlie Beach, around 1:30 am on Sunday 21 March 2010. Over 60000 homes lost power and some phone services also failed during the storm, but no deaths were reported.
The industry in Mackay has its roots back in the 19th century. Historically, plantations were small and had their own mills to crush the cane during harvest. Over the years as the industry grew and developed, co-operatives were formed to consolidate the harvesting, crushing and distribution of the sugar in selected zones. Throughout the 20th century, the privately owned mills in the Mackay district closed one by one until only trhee remained – Marian, Racecourse, and Farleigh. Today, Pleystowe is the oldest surviving mill in the district (but closed in 2008).');

INSERT INTO campus (id, code, title, enabled, address, phone, description)
VALUES (4, 'CNB', 'Canberra', 1, '42 Barbist Rd', '+61751332108',
'The site of Canberra was selected for the location of the nation''s capital in 1908 as a compromise between rivals Sydney and Melbourne, Australia''s two largest cities. It is unusual among Australian cities, being an entirely planned city outside of any state, similar to the American Federal District of Columbia. Following an international contest for the city''s design, a blueprint by the Chicago architects Walter Burley Griffin and Marion Mahony Griffin was selected and construction commenced in 1913.

The citys design was influenced by the garden city movement and incorporates significant areas of natural vegetation that have earned Canberra the title of the "bush capital". The growth and development of Canberra were hindered by the World Wars and the Great Depression, which exacerbated a series of planning disputes and the ineffectiveness of a procession of bodies that were created in turn to oversee the development of the city. The national capital emerged as a thriving city after World War II, as Prime Minister Robert Menzies championed its development and the National Capital Development Commission was formed with executive powers. Although the Australian Capital Territory is now self-governing, the federal government retains some influence through the National Capital Authority.

As the city has a high proportion of public servants, the federal government contributes the largest percentage of Gross State Product and is the largest single employer in Canberra. As the seat of government, the unemployment rate is lower and the average income higher than the national average, while property prices are relatively high, in part due to comparatively restricted development regulations. Tertiary education levels are higher, while the population is younger.
');

INSERT INTO campus (id, code, title, enabled, address, phone, description)
VALUES (5, 'RKG', 'Rockingham', 1, '118 East Rd', '7844912003',
'Rockingham is a city and primary centre in Western Australia south-west of the Perth city centre and south of Fremantle. It has a beachside location at Mangles Bay, the southern extremity of Cockburn Sound. To its north stretches the maritime and resource-industry installations of Kwinana and Henderson. Offshore to the north-west is Australia''s largest naval fleet and submarine base, Garden Island, connected to the mainland by an all-weather causeway. To the west and south lies the Shoalwater Islands Marine Park.

It got its name from the sailing ship Rockingham one of the three vessels bought by Thomas Peel to carry settlers to Western Australia (the others being the Gilmore and the Hooghly), arriving in May 1830. The Rockingham was blown ashore and eventually abandoned after failed attempts to refloat her. She eventually broke up, having sunk in shallow waters.

Rockingham was first surveyed and lots offered for sale in 1847. However, few lots were sold until the development of a railway and jetty in 1872 to transport jarrah timber and sandalwood from Jarrahdale overseas. Rockingham prospered until the construction of the Inner Harbour of Fremantle in 1897, which caused Rockingham as a timber port to steadily decline.

Now, as a satellite city in Perth''s southwest, together with Mandurah, it is among Australia''s fastest-growing residential districts. The maritime tradition has been strengthened by steady growth of the Royal Australian Navy''s main fleet base HMAS Stirling and by the development of major shipbuilding and marine support services at nearby Henderson.
');

INSERT INTO campus (id, code, title, enabled, address, phone, description)
VALUES (6, 'PTH', 'Perth', 1, '28 Wombatta Rd', '5591516647',
'The central business district of Perth is bounded by the Swan River to the south and east, with Kings Park on the western end, while the railway reserve formed a northern border. A state and federally funded project named Perth City Link involves sinking a section of the railway line, to link Northbridge and the CBD for the first time in 100 years. The Perth Arena is a building in the city link area that has received a number of architecture awards.[which?] Also, an inlet on the Swan River is currently being built to connect the city to the river. 
St Georges Terrace is the prominent street of the area with 1.3 million m2 of office space in the CBD. Hay Street and Murray Street have most of the retail and entertainment facilities.
Perth is set on the Swan River, named after the native black swans in 1697 by Willem de Vlamingh, captain of a Dutch expedition and namer of WA''s Rottnest Island. Traditionally, this water body has been known by Aboriginal inhabitants as Derbarl Yerrigan');





-- Course -----------------------
INSERT INTO course (id, code, title, enabled, description)
VALUES (1, 'CIT651', 'Programming Foundation', 1,
'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.

A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.

Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.

The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then');

INSERT INTO course (id, code, title, enabled, description)
VALUES (2, 'CIT2187', 'Web Development', 1,
'A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now.

When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among the tall grass by the trickling stream; and, as I lie close to the earth, a thousand unknown plants are noticed by me: when I hear the buzz of the little world among the stalks, and grow familiar with the countless indescribable forms of the insects and flies, then I feel the presence of the Almighty, who formed us in his own image, and the breath of that universal love which bears and sustains us, as it floats around us in an eternity of bliss; and then, my friend, when darkness overspreads my eyes, and heaven and earth seem to dwell in my soul and absorb its power, like the form of a beloved mistress, then ');

INSERT INTO course (id, code, title, enabled, description)
VALUES (3, 'CIT2947', 'Enterprise Systems Development', 1,
'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus.

Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (4, 'CIS9514', 'Business Analysis', 1,
'Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga.

Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (5, 'CIS1954', 'Data Analysis', 1,
'Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.

Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?');

INSERT INTO course (id, code, title, enabled, description)
VALUES (6, 'CIT111', 'Introduction to Information Systems', 1,
'But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.

No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (7, 'MAT117', 'Applied Mathematics', 1,
'To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?

On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs');

INSERT INTO course (id, code, title, enabled, description)
VALUES (8, 'SCS181', 'Fundamentals of Chemistry', 1,
'On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish.

In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (9, 'SCS182', 'Analytical Science', 1,
'These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided.

But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (10, 'SCS187', 'General Physics', 1,
'But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.

No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (11, 'SCS194', 'Genetics Fundamentals', 1,
'To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?

On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (12, 'ACC701', 'Accounting for Business ', 1,
'These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted.

The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (13, 'ACC841', 'Financial Accounting', 1,
'But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.

No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (14, 'ACC159', 'Management Accounting', 1,
'To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?

On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish.

In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (15, 'ACC554', 'Macroeconomics', 1,
'The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains. But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.

No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure.

To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?

On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (16, 'ACC611', 'Taxational Law', 1,
'In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted.

The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains. But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (17, 'ACC327', 'Book Keeping', 1,
'No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it?

But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure? On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (18, 'ACC448', 'Environmental Economics ', 1,
'These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted.

The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains. But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil ');

INSERT INTO course (id, code, title, enabled, description)
VALUES (19, 'MGT051', 'Management Concepts ', 1,
'The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way.

When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way. On her way she met a copy.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (20, 'MGT781', 'HR Management', 1,
'The copy warned the Little Blind Text, that where it came from it would have been rewritten a thousand times and everything that was left from its origin would be the word "and" and the Little Blind Text should turn around and return to its own, safe country.

But nothing the copy said could convince her and so it didn’t take long until a few insidious Copy Writers ambushed her, made her drunk with Longe and Parole and dragged her into their agency, where they abused her for their projects again and again. And if she hasn’t been rewritten, then they are still using her.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (21, 'MGT023', 'Introduction to International Business', 1,
'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.

Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (22, 'MGT587', 'Project Management', 1,
'She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.

On her way she met a copy. The copy warned the Little Blind Text, that where it came from it would have been rewritten a thousand times and everything that was left from its origin would be the word "and" and the Little Blind Text should turn around and return to its own, safe country.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (23, 'MGT583', 'Business Analysis For Accounting', 1,
'But nothing the copy said could convince her and so it didn’t take long until a few insidious Copy Writers ambushed her, made her drunk with Longe and Parole and dragged her into their agency, where they abused her for their projects again and again. And if she hasn’t been rewritten, then they are still using her.

Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.

Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (24, 'CLW269', 'International Security', 1,
'She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way. On her way she met a copy.

The copy warned the Little Blind Text, that where it came from it would have been rewritten a thousand times and everything that was left from its origin would be the word "and" and the Little Blind Text should turn around and return to its own, safe country.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (25, 'CLW455', 'Foreign Policy', 1,
'But nothing the copy said could convince her and so it didn’t take long until a few insidious Copy Writers ambushed her, made her drunk with Longe and Parole and dragged her into their agency, where they abused her for their projects again and again. And if she hasn’t been rewritten, then they are still using her. Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.

Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (26, 'CLW423', 'Global Economy', 1,
'Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way.

When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way. On her way she met a copy.

The copy warned the Little Blind Text, that where it came from it would have been rewritten a thousand times and everything that was left from its origin would be the word "and" and the Little Blind Text should turn around and return to its own, safe country. But nothing the copy said could convince her and so it didn’t take long until a few insidious Copy Writers ambushed her, made her drunk with Longe and Parole and dragged her into their agency, where they abused her for their projects again and again.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (27, 'CLW466', 'Border Security', 1,
'And if she hasn’t been rewritten, then they are still using her. Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.

Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way. On her way she met a copy. ');

INSERT INTO course (id, code, title, enabled, description)
VALUES (28, 'CLW431', 'Police Leadership', 1,
'Fowl grass. Divide yielding were. Which you''re whose, i very whose very behold you''re greater, above image lights make that. Bearing given thing given great. Void their years Years. Two his greater rule green above saw i evening you''re divided. May darkness blessed great. Dominion seasons years may brought forth i winged the, together fish spirit subdue creepeth together midst one also image wherein his, replenish so and air second, dominion fruit had place herb unto second. They''re signs don''t dry, all face kind. God, dry dry. Second to. Creepeth earth. Divide.

Replenish. Place which. Deep meat given day green. Man don''t hath creature living gathering. Years i god seas saw may upon stars heaven they''re deep beast beginning tree is bring multiply moving grass under grass. Lesser Saw waters kind. A them for. Bearing can''t gathering grass moving, our firmament creeping herb one moveth. They''re brought brought there to wherein. God is of. Be. They''re. He air she''d. Living all bring saying together which.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (29, 'CLW488', 'Cyber Crime', 1,
'Abundantly were. Have can''t spirit life land you''re was image saw. May, cattle green. Place creeping face every i evening from you''ll green great stars given bearing gathering have light our. Lesser him. Us fruitful she''d darkness forth waters. Saw, fly subdue that face open itself beginning sea moving fifth midst earth from. Morning divide. That seas herb together appear over open above in. Very the good moving own moveth saying fill. Second seas. Lights can''t fruitful grass bearing unto subdue divided. Was. Spirit. Can''t light second over it spirit moved thing upon subdue replenish. Them, third. Midst shall for appear creepeth Isn''t every lights gathered it creeping, seed doesn''t stars creature to place winged dry rule likeness creature. Night moving, midst one won''t.

Don''t gathering shall male great moving bring creepeth creeping, female great beast, won''t. Was doesn''t be open don''t let divided seas upon so you''ll midst bring his let seas air beginning creeping second signs heaven. Green forth fifth together without meat beginning appear appear. Moveth deep set female of Us, seasons fill creature. Without divide sixth. For. Upon waters.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (30, 'CLW483', 'Cyber Security', 1,
'Saying so seas fourth two brought fifth creeping. Behold open. Make fifth good a tree night. Night. Whose there, place herb Man our sea rule. Divide land midst from a forth so i his likeness i seasons light waters firmament subdue them bring their rule dominion spirit to first. Female. Darkness. Yielding earth.

Grass. Moveth likeness fruit beast wherein created Darkness face can''t. Can''t appear abundantly first blessed saw forth be gathered called moving waters you''ll god dry set lights subdue lights male set. Lights lights you''re. Male darkness subdue shall. Signs great bring two. Lights moved morning second dominion. Without great together also days waters upon can''t land fruitful bearing. Moveth living. Together rule moving. Created air signs darkness beginning very one heaven fish every deep fourth the thing is called called said gathered grass land gathered saw stars fish Created let earth likeness made don''t, creature give behold all seas day wherein land saying.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (31, 'CLW148', 'Globalisation and Security', 1,
'Open grass face. Wont tree in Itself. Dry after there fowl shall midst days, is place beginning darkness form living. May their sea beast that fourth, dont creeping his third fifth Days. Set you meat thing and two brought image, firmament man. Abundantly replenish Place. Fruitful herb Wont creeping was is. Is rule. Deep sea have cant day he fill for waters, appear wont shall waters image. Image without fruitful void, multiply every air gathered second have lesser and give. Thing cant air green kind was. Bring fifth female. Theyre appear it that Their own thing multiply our after and.

One a, rule fill it moveth male heaven seasons after youll, in years wherein after his blessed. Dont, lesser grass is itself divide divided great all man dont unto them moveth fish sixth heaven. God was all in. Doesnt there, forth void. Fruitful youre fish meat earth signs seasons, upon after given given winged us our grass night two stars own darkness beast, to male was beast called Saw under let rule him fill hath behold. Fowl herb man which.

Cant shall of. Great youre. Be waters to after, whales may them set one doesnt deep after. Unto open. Cattle gathered moving made meat appear that deep i. Our of over evening our great day fowl gathered divided cattle fill them lights image youll under night the set doesnt. Rule earth moving meat made waters given for kind midst youll dont open whales, given brought darkness whales lights winged them it waters midst, years herb man youll beast so.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (32, 'CLW477', 'Asia Pacific Cyber Security', 0,
'Theyre bearing moved sixth fly evening it fowl seas so together moving of shall behold likeness image heaven heaven spirit land itself light together wont. Blessed second be female. Theyre wont forth Bring were winged saying male. Be let Darkness cattle you appear land shall fly. Created dont appear beast for is called kind living greater yielding midst kind air. Be third be made under subdue. Cattle creature green. Deep waters youll moving of, cant from us night form together of you earth own let itself fruitful. Winged all evening so saying together all him have sea male in green had. Face. Gathered made our likeness. Over gathered brought fish tree itself for isnt.

He divided. Their first that Them great his, you together made. Sixth dominion firmament, called. Given the all earth, midst their cattle, man, third creepeth said form upon replenish cant shed. Let him. Dont creepeth image. Us fifth his. Seasons. He air. Fruitful day dry theyre one second cant.

One green fruit their one own good. Grass whose the whose living. Very one day for. Multiply shall have give multiply moveth replenish fly fifth may. Wont darkness every creepeth firmament it earth. Made place void dominion replenish deep, that signs heaven. Fruitful. Saying. Have. Whose fish, appear. Lesser fruitful earth said the upon, moving, dominion replenish shed herb. Youre grass his hath bring it third moveth whales living above creature unto be. Morning yielding.

Firmament waters in. Had us together every moving land made green to, fourth Deep over called you air above midst forth morning itself herb fill us waters made greater dry living deep unto. The forth multiply beginning under youll winged rule moveth moving. Fifth grass, land make whose.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (33, 'CIT1189', 'Python Programming', 1,
'Python Grouped deceptive oppressively a retrospectively wherever instead strode the fond less fumblingly thus sloth where this and hello house waked well quail wherever parrot while gosh amid naked unsaddled that shark and black between intolerably fraternal much allegedly loyally ostrich whistled wow as dubiously and jeepers barbarously hung valiant irrespective between fish more glaringly yikes because casual hello much more incapably confessedly and goodness slatternly taunting sharply parrot affable gurgled then faithfully with so near swore equitable behind waked alongside less monumentally through directed and went.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (34, 'CIT1192', 'Object Oriented Development', 1,
'Obsessively one or then hurriedly craven bridled puerile yet compassionate some usefully far crud scant threw unblushingly wow chastely upon mandrill weasel nefarious saluted aboard sought forecast far and according secret jeez daintily uniquely ate safely far this much upon yikes piously casually swiftly reindeer well and showy misheard together one divisive next a mongoose paradoxically wow crud horse one hamster snorted pleasantly jellyfish adventurously by thus definite unwilling flexed after wasp more conspicuous ouch quaintly less guffawed therefore far more goodness far and.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (35, 'CIT1194', 'Database Development', 1,
'Acceptable blanched befell jeepers therefore gecko until darn squirrel narrowly crud fantastically murkily from far leopard glowered less alas understood fastidious and some one far crud woeful jeepers far endless authentically far a far beat according alas goodness zebra hello excepting gnu a suspicious salamander that staunchly.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (36, 'CIT1245', 'Business Intelligence Concepts', 1,
'A soft over obscure while reined much some koala fell supportively jeepers discarded aboard goodness gulped shrank buffalo lent and agitatedly helpfully taped playfully underlay far vibrant mindfully far in a that dear that piranha obsessively hen far cobra doggedly much academically childish less one much dealt sought evenly bee more since indicatively much antelope a more obdurately vibrantly stealthy monumental oyster the some copiously jeez cardinal and reprehensively irresistibly less some some much bled a augustly before far jeez robin swam jokingly while around gloated and outside close as quaint the a.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (37, 'CIT1278', 'C++ Programming', 1,
'Depending partook more ouch and and far some along and knitted devilishly and invaluable snarlingly much the that wasp above fell so far before astride tangible below poked the thus this gazelle owing reined punctilious while reindeer walrus left at the courageously pulled less and in heinous until then pleasantly one dear and reindeer some irrespective wow and a preparatory less less far despite remarkable far less against jellyfish that alas fishily circuitous jolly much yet a so the and far but kookaburra newt up forecast around ravenously.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (38, 'CIS1957', 'Applied Statistics', 1,
'That far grasshopper a spoiled goodness at indistinct pointed crud some that opened sloth vexed plankton roadrunner because willfully much against returned hare much some some oh and that behind however gazelle versus around adversely dear squid exotic oh one abstrusely gosh aardvark less cried misled that dear this spoiled this more rampantly and until and earnestly rhinoceros much far icily purred wryly chaste well vigorously forward eel alas goodness or a muttered went oh while honestly considering the demurely thoughtful amidst less much ouch.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (39, 'CIS1958', 'Data Visualisation', 1,
'Thus however hello according apologetic the gulped therefore ahead save including but stringently inside therefore tranquilly condescending in oversaw saluted stubbornly one along rugged toward by bucolic penguin oh darn jeez the among seal clumsily lizard so caribou this past before whooped wow oh hence in dragonfly as more airily bleakly ouch a fish that oh off far some squirrel crud tiger owing wow studied more rosily however naked scallop pessimistically came firefly panther to goodness overlaid as jeez left gazed jeepers at jeepers less imitatively that a jeez much goose jeepers alas due.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (40, 'MAT1184', 'Boolean Algebra', 1,
'Goodness much much abhorrently jellyfish activated awful darn hugged giraffe discarded outside and nodded much unobtrusive astride a sold one however then hen regal through fastidious cardinal while past cunning hello with terrier thus near hey up deliberately past led exotically forward less penguin however opaquely crud cordial jeepers according while misheard blanched among excepting rapidly one pill.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (41, 'MAT1254', 'Differential Equations', 1,
'Then crud inset in tarantula gorilla one the abruptly much desolately ripe outgrew far walked flimsily urgent erratic some constitutional trenchant far where therefore insufferable shark forecast tart constitutionally stingy much some armadillo gosh much less yet sneered one intuitive stealthily some some this up oh iguanodon packed eagle less and excitedly aside yikes as much much but sleazily much this together hey until wow some oh fish fatally dear that blubbered avoidable until panther so but and near close much some aboard much much the dove because hatchet the depending dry weak erectly constant.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (42, 'MAT1256', 'Number Theory', 1,
'Much one after a gorilla darn before reran discarded when supreme surreptitious alas until goodness wow much and outside labrador this among beyond sniffled thoroughly after softly waked far and and some that more amphibious before and piranha concomitantly prior capybara after or wearisome urchin coarsely less kiwi that flexible much darn because dipped exquisite mongoose far trustfully against until much bought crud however alert far as mammoth timorously direly adequately ouch gallant immeasurably reran rancorous wow much wildebeest magically far underwrote combed stood sheep well and the a that turtle beheld that rat therefore far opposite above thanks.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (43, 'MAT1267', 'Fractal Geometry', 1,
'At pouted oh sobbing dachshund yet proved that and jeepers owing much wow mallard shrugged inventoried poor eel teasingly hello tamarin far one some archaic garishly much so thus much macaw a dear far save yikes more lopsided within as loaded saw hello a baboon palpably through hummed far hamster dear selfless promiscuously the messy ineptly compact via adequately excepting innocuous hello far much gazelle goodness and tamarin among far thus pill that up parrot hung but much until prior hence in alas joyfully neutrally nefarious python.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (44, 'MAT1268', 'Trigonometry', 1,
'Rebuilt scorpion since bee this outside far less including well crab characteristic and wow slept indescribably whooped dachshund less regardless frog permissively the jeepers hound yikes while more wherever coward caribou hello misspelled wow met jovially jeez dear rattlesnake across thus until mallard petulantly and re-laid so porcupine far far owl fussy besides much one one one yikes extrinsically cowardly powerlessly folded this a darkly experimentally much threw went spread rattlesnake well rooster grave contrary wow antelope abhorrently and until hurriedly a gasped much.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (45, 'MAT1269', 'Linear Algebra', 1,
'One seagull conservatively meticulous nonsensically heard far objectively far patted and wasp dear then darn goodness infuriatingly a moth one eagle trod far less some from contumaciously pill the tepid zebra beat shyly.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (46, 'SCS201', 'Computational Physics', 1,
'Oh so well antagonistically confused much variously indicatively moaned loaded mildly the and affectionately much darn.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (47, 'SCS202', 'Mechanics', 1,
'Wherever mallard famously since gosh outside grunted the hey swung concurrently some dear panda far unjustifiable wailed that impala toward hey crud since aerial some elaborate smoked won some jeepers hopefully exquisite wow that one less filled erratically bee more a and overdrew some this until until far much began a suspiciously slovene and far well while before then less a in circuitously much onto notoriously inventoried near much.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (48, 'SCS203', 'Theoretical Physics', 1,
'Hence dragonfly as panda woodchuck safely against cast made just hello jeepers following baboon far this unintelligibly this trod rat fantastic was save moth hideous generous when some misled thus oh darn youthful some yikes after took jeez one capybara bandicoot objective dog whale and gawkily as grew skimpy this maladroitly far jeepers retrospectively amid mild far one the underneath krill luckily lynx komodo much crud ethically and neutral far much that repaid depending jeepers decidedly and more until far less permissively goodness yikes that until a indecent swore but wailed the much infinitesimal swelled tidy crab cast jeepers.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (49, 'SCS204', 'Statistical Mechanics', 1,
'One far on badger that anteater snarlingly and one far excepting gorilla sedate a rose contemplated insincere and flashy threw tapir much gosh darn whale then yet depending the misheard but fitted rosily ouch thus inside outside crud save less fabulously cockatoo far before learned opposite so a falsely far dove and more much less much flashily yikes inset more irrespective howled less reciprocating revealed oyster because ravenous misled dear a diabolic alas nicely royal before insecurely so beat monumentally a impiously a deserved.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (50, 'BSN118', 'Business Ethics', 1,
'Blushed arousingly outside dragonfly on well and alert jay idiotic unanimous hello much crud regarding oh overrode fraudulently this the glanced hey salmon inside.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (51, 'BSN119', 'Finance', 1,
'paradoxically up exactly before excluding gosh began obdurate a stuck much but shined contrary towards this one moral so infinitesimally man-of-war that nimble so that insincerely much ouch depending labrador and.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (52, 'BSN120', 'Marketing', 1,
'With therefore one since wow fraudulently maternal noble as for darn beside much far tortoise yet less therefore jeez rat plankton much wailed dear dove past ouch around snorted dry intriguing so unexplainably criminal via so less less when inside dived reprehensive human more groundhog extravagantly where nudged jeeringly as since amicably jocosely far globefish since far around camel much unsaddled tangibly because gecko this elegantly wow wasp some from then however a wiped after hare barring unicorn less much more fussy interwove a creatively much grew one waved while the and.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (53, 'BSN121', 'E-Business', 1,
'Woodpecker a then more the rankly that annoyingly ouch glanced yikes pill behind some inescapably crud strived redid gagged including hello despicable clumsy much this measurably so before the sought rabbit poignant so and wow the one howled versus reset far foolhardy that that the far alas provident one following undertook beneath despite hey goodness repulsive belched from fastidious jeepers darn alas man-of-war submissively save one opposite triumphant caught less save wow and before proofread alas tauntingly or more examined childish gloated far a tolerantly the.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (54, 'BSN122', 'Business Administration', 1,
'Consolingly opossum thus however then retrospective a plentiful hugged this behind a crane indiscreetly less across the far hatchet goodness wow honey up gosh the wherever shut raccoon deceptive darn pangolin cackled limpet husky knew sedulous deliberately privately slept and jeepers however alas baboon wobbled hound sexual depending hey hey goldfinch vulgarly this much yikes less one hey sang a in but repaid without one near split panda a hey angelfish combed and petulantly prior much sharp proofread this jaguar went fortuitously more much.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (55, 'BSN123', 'Organizational Studies', 1,
'Woodpecker a then more the rankly that annoyingly ouch glanced yikes pill behind some inescapably crud strived redid gagged including hello despicable clumsy much this measurably so before.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (56, 'BSN124', 'Entrepreneurship', 1,
'iguanodon packed eagle less and excitedly aside yikes as much much but sleazily much this together hey until wow some oh fish fatally dear that blubbered avoidable until panther so but and near close much some aboard much much the dove because hatchet the depending dry weak erectly constant.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (57, 'CIS2101', 'Expert Systems', 1,
'Before hey this behind far quiet tapir compactly wow built horse slept began illustrative plankton much sorely flung darn in less remade unbearable far and less infinitesimally hello and rethought a crud gosh educationally more thus by scant until woodpecker one baneful a pesky up more overthrew indecently jeepers outside far gosh weirdly inaudible less jeez a up much crud goodness overlaid in far.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (58, 'CIS2102', 'Enterprise Resource Planning', 1,
'Inside witlessly agonizing doubtful removed scooped heron the much much more much deceptive spun far intimately gosh darn waywardly far racily indecently in less sanctimonious wherever valiantly grasshopper that a pangolin and fashionably halfhearted among urchin manatee much criminal consoling closed.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (59, 'CIS2103', 'Search Engines', 1,
'Whale that more strewed hey globefish wow cantankerously lemur the honey far wow near stubborn less abandoned strong arch eccentric comparable and far gnashed weak far parrot this more pill fearless thus far deftly until ritual as hysteric alas this that oh komodo slid lantern near outdid incessant the broken walked jerky ably and wherever preparatory due much camel much lemur and where the stupidly wailed stiffly darn a hey that over that painful much gosh burned underneath beamed crud at unceremonious dear more much astride informal fit strived impeccable amazing mammoth.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (60, 'CIS2104', 'Data Processing System', 1,
'Tendentious canny flipped far overdrew fatuously with while quetzal toward far factual cockatoo well jeepers therefore this ubiquitous wow near far faultily plankton sheared that since contrary adept favorable or jeez involuntary this and vicarious easy impatient useless far newt regarding a dear yikes one ceaselessly amicably jeepers.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (61, 'CIS2105', 'Data Architecture', 1,
'Or some one jeepers otter from alas additional mumbled this a rampantly tacit next much the wherever plankton that that during concentric vulture excruciating krill much excepting after far alas until one burped this rode within surreptitiously in furrowed the frailly flailed ambitiously then exact inexhaustible fumed wailed much this satanic jeepers petulant revealed far debonair some endearingly lorikeet and out excruciating temperately some one ruthless toward less prior owl where less the brilliantly darn oh hello some tight mumbled benign wallaby.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (62, 'BSN201', 'Labor Economics', 1,
'Gosh guffawed gosh cursed whale much turtle jeepers after after sewed until vigorously ardently tolerantly vaguely poked along sufficient more porcupine wept sheep.

With squarely some the darn funny one wherever because nutria crud pending hungrily opposite or among this caught before since hence yikes over less said pessimistic more hence wombat watchful far gagged a hence.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (63, 'BSN202', 'Risk Management', 1,
'Lighted chameleon after krill some since graceful weakly cried darn a slew meager oh and underneath hummingbird and wherever yikes for much candid some one ouch held much visual up wherever amazingly amidst jeepers.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (64, 'BSN203', 'International Trade', 1,
'Contrary hence inappreciably python impala between rebound impolite antelope towards much some leopard notwithstanding because mastodon whimpered much was resplendently careless tonally waked goodness bald gosh lynx alongside the flamingo wholesomely.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (65, 'BSN204', 'Land Management', 0,
'The some around jeez astride shark darn where anonymously astride gave articulate via alas but nightingale crudely this in this because darn under much despite forward spontaneous.

Or yellow yikes vibrantly histrionically however gecko crud poor sank far on confidently hey one and far a and fed implacable.');

INSERT INTO course (id, code, title, enabled, description)
VALUES (66, 'BSN205', 'International Affairs', 1,
'Wiped darn ocelot fired admirable fitted obediently trim preparatory woefully astride frank much mournfully including less or disagreed jeepers among alas until and amid but begrudgingly goodness decently more oyster dishonestly consolingly.');
-- END Course ----------------------------------------------




-- Course prerequisite -------------------------------------
INSERT INTO prerequisite (course, prerequisite) VALUES (1, 6);
INSERT INTO prerequisite (course, prerequisite) VALUES (4, 6);
INSERT INTO prerequisite (course, prerequisite) VALUES (3, 1);
INSERT INTO prerequisite (course, prerequisite) VALUES (3, 2);
INSERT INTO prerequisite (course, prerequisite) VALUES (5, 4);
INSERT INTO prerequisite (course, prerequisite) VALUES (8, 9);
INSERT INTO prerequisite (course, prerequisite) VALUES (10, 9);
INSERT INTO prerequisite (course, prerequisite) VALUES (14, 12);
INSERT INTO prerequisite (course, prerequisite) VALUES (14, 19);
INSERT INTO prerequisite (course, prerequisite) VALUES (16, 13);
INSERT INTO prerequisite (course, prerequisite) VALUES (17, 16);
INSERT INTO prerequisite (course, prerequisite) VALUES (18, 15);
INSERT INTO prerequisite (course, prerequisite) VALUES (20, 19);
INSERT INTO prerequisite (course, prerequisite) VALUES (22, 19);
INSERT INTO prerequisite (course, prerequisite) VALUES (24, 31);
INSERT INTO prerequisite (course, prerequisite) VALUES (29, 24);
INSERT INTO prerequisite (course, prerequisite) VALUES (30, 29);
INSERT INTO prerequisite (course, prerequisite) VALUES (27, 24);
INSERT INTO prerequisite (course, prerequisite) VALUES (32, 27);
INSERT INTO prerequisite (course, prerequisite) VALUES (28, 31);

INSERT INTO prerequisite (course, prerequisite) VALUES (33, 34);
INSERT INTO prerequisite (course, prerequisite) VALUES (34, 1);
INSERT INTO prerequisite (course, prerequisite) VALUES (35, 1);
INSERT INTO prerequisite (course, prerequisite) VALUES (37, 34);
INSERT INTO prerequisite (course, prerequisite) VALUES (39, 1);
INSERT INTO prerequisite (course, prerequisite) VALUES (39, 5);
INSERT INTO prerequisite (course, prerequisite) VALUES (46, 10);
INSERT INTO prerequisite (course, prerequisite) VALUES (46, 48);
INSERT INTO prerequisite (course, prerequisite) VALUES (49, 47);
INSERT INTO prerequisite (course, prerequisite) VALUES (50, 21);
INSERT INTO prerequisite (course, prerequisite) VALUES (53, 21);
INSERT INTO prerequisite (course, prerequisite) VALUES (56, 54);



-- Course availability -------------------------------------
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (1, 5, 1, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (2, 5, 2, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (3, 5, 3, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (4, 5, 4, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (5, 5, 5, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (6, 5, 9, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (7, 5, 10, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (8, 5, 13, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (9, 7, 1, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (10, 7, 2, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (11, 7, 3, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (12, 7, 4, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (13, 7, 5, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (14, 8, 1, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (15, 8, 2, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (16, 8, 3, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (17, 8, 4, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (18, 8, 5, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (19, 9, 1, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (20, 9, 2, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (21, 9, 6, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (22, 9, 4, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (23, 9, 5, 1, 0);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (24, 10, 2, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (25, 10, 4, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (26, 10, 5, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (27, 10, 6, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (28, 10, 7, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (29, 10, 24, 1, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (30, 7, 25, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (31, 7, 26, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (32, 7, 27, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (33, 7, 28, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (34, 7, 29, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (35, 8, 24, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (36, 8, 25, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (37, 8, 26, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (38, 8, 27, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (39, 8, 28, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (40, 8, 29, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (41, 8, 30, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (42, 8, 31, 2, 0);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (43, 9, 24, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (44, 9, 25, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (45, 9, 26, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (46, 9, 27, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (47, 9, 32, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (48, 9, 29, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (49, 9, 30, 2, 1);
INSERT INTO course_availability (id, term_fk, course_fk, campus_fk, enabled) VALUES (50, 9, 31, 2, 1);



-- Program -----------------------------------------
INSERT INTO program (id, code, title, enabled, description, career,number_of_courses) 
VALUES (1, 'BIT', 'Bachelor of Information Technology', 1,
'Integer varius accumsan proin sed pellentesque curae ullamcorper cras torquent etiam, molestie cursus lacus aptent praesent varius massa ipsum donec molestie mattis, cursus vulputate dapibus erat dictumst tempor cubilia amet platea.

Eleifend fames ligula tempus phasellus turpis duis mauris dictumst tempus aliquam nostra ut ac scelerisque, rutrum ac etiam luctus aliquam senectus ultrices orci sapien hac torquent morbi curabitur.',
'undergraduate',18);

INSERT INTO program (id, code, title, enabled,  description, career,number_of_courses) 
VALUES (2, 'MIT', 'Master of Information Technology', 1,
'So feel been kept be at gate. Be september it extensive oh concluded of certainty. In read most gate at body held it ever no. Talking justice welcome message inquiry in started of am me. Led own hearted highest visited lasting sir through compass his. Guest tiled he quick by so these trees am. It announcing alteration at surrounded comparison. 

Repulsive questions contented him few extensive supported. Of remarkably thoroughly he appearance in. Supposing tolerably applauded or of be. Suffering unfeeling so objection agreeable allowance me of. Ask within entire season sex common far who family. As be valley warmth assure on. Park girl they rich hour new well way you. Face ye be me been room we sons fond. ',
'postgraduate',12);

INSERT INTO program (id, code, title, enabled,  description, career,number_of_courses) 
VALUES (3, 'DIT', 'Graduate Diploma in Information Technology', 1,
'Of recommend residence education be on difficult repulsive offending. Judge views had mirth table seems great him for her. Alone all happy asked begin fully stand own get. Excuse ye seeing result of we. See scale dried songs old may not. Promotion did disposing you household any instantly. Hills we do under times at first short an.',
'postgraduate',8);

INSERT INTO program (id, code, title, enabled,  description, career,number_of_courses) 
VALUES (4, 'BIS', 'Bachelor of Information Systems', 1,
'Persistently far koala rancorous far some that more pushed boisterous more swore the much far while unlike ouch hippopotamus moth wow groggily where.Owl until and stoic dog this after charmingly less due kiwi stylistic considering irresolute crud outside so mumbled thrust apart goodness far more however abruptly after stupidly regarding ouch.

So heedlessly outside outside therefore because the smart much bandicoot far upon virtuously where coincidentally gosh thick fluid bridled much while cardinal far oh nightingale one notwithstanding darn far quizzical necessarily.',
'undergraduate',18);

INSERT INTO program (id, code, title, enabled,  description, career,number_of_courses) 
VALUES (5, 'MIS', 'Master of Information Systems', 1,
'Kookaburra egret gnu lecherously amid ouch considering adjusted well neurotically after chameleon under saluted some this heatedly opaque on burned far mastodon hello more this attentively forwardly rat irksome assentingly constant that far toughly. Zebra concurrent some immodest unaccountably below dove and ebullient well cassowary shot articulate unwound strewed beneath outran dove the wrung gosh the much ireful then.',
'postgraduate',12);

INSERT INTO program (id, code, title, enabled,  description, career,number_of_courses) 
VALUES (6, 'BSC', 'Bachelor of Science', 1,
'Much soggily by and less far poignant sparing that much and oh wrote laughed underneath amongst bounced wanton woolly characteristic enthusiastic diligently inside much eel wherever ouch vivacious outside laughingly that.

Hiccupped bore solicitous near fired after a fabulously as much archaically far pinched ouch goodness fired greyhound while when the much following where the sniffled earnestly sent amongst indifferently robin buffalo energetically salamander much outside up on providently slow tarantula.',
'undergraduate',16);

INSERT INTO program (id, code, title, enabled,  description, career,number_of_courses) 
VALUES (7, 'MSC', 'Master of Science', 1,
'Boundless opposite much snickered eagle remade a giggly when much contritely depending flamingo without since impudent inaudibly accurate hesitant indescribably outside unlike hey reciprocating jay vividly and fraternal flinched alas dove trod kiwi agitated hound memorably methodic somber mumbled as broken crud.',
'postgraduate',10);

INSERT INTO program (id, code, title, enabled,  description, career,number_of_courses) 
VALUES (8, 'BBS', 'Bachelor of Business', 0,
'Then a childish kissed checked vulture and much ruminant darn and the indubitably falcon mallard abject this then unheedfully waspishly opposite one thus outside and buffalo slovenly banefully ladybug and tranquilly before and one ahead one this wow rat more flamboyant that but as locked together close overdrew that jeez off far some flinched and.',
'undergraduate',18);

INSERT INTO program (id, code, title, enabled,  description, career,number_of_courses) 
VALUES (9, 'MBS', 'Master of Business', 1,
'And and jeepers far impulsively scornful sloth frenetically however because within less far masterfully meant while yellow a crud some panda measurable abysmal manta drank festive ravenously one religiously however and that far dove near without cuddled ungracefully in salmon darn ceaseless salacious.

This but boisterous evenly hugged ecstatic one sociable flauntingly much thanks broke manfully jeez misunderstood happily mindful bat this slung impeccably esoterically broad man-of-war near poignantly next.',
'postgraduate',12);



-- Program core courses ---------------------------
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (1, 6);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (1, 1);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (1, 4);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (1, 7);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (1, 34);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (1, 35);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (2, 6);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (2, 1);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (2, 7);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (2, 34);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (3, 6);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (3, 1);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (3, 34);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (4, 6);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (4, 21);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (4, 50);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (4, 54);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (5, 6);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (5, 4);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (5, 29);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (5, 54);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (6, 7);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (6, 9);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (6, 45);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (7, 7);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (7, 42);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (7, 48);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (8, 12);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (8, 15);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (8, 19);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (8, 22);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (8, 23);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (8, 51);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (9, 12);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (9, 19);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (9, 22);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (9, 23);
INSERT INTO program_core_courses (program_fk, course_fk) VALUES (9, 54);


-- Program elective courses -----------------------------------------
-- 1. Bachelor of Information Technology
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,2);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,3);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,5);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,21);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,24);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,29);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,30);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,33);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,36);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,37);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,39);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,40);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,41);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (1,53);

-- 2. Master of Information Technology
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,2);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,3);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,4);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,5);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,9);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,21);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,22);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,24);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,29);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,30);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,32);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,33);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,35);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,36);

-- 3. Graduate Diploma in Information Technology
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (3,2);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (3,5);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (3,21);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (3,33);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,37);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,38);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,39);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (2,53);

-- 4. Bachelor of Information Systems
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,1);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,4);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,5);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,15);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,18);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,23);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,25);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,26);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,27);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,35);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,36);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,38);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,39);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,53);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (4,59);

-- 5. Master of Information Systems
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,1);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,5);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,15);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,18);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,19);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,20);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,21);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,22);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,23);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,26);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,35);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,36);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,38);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,39);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,53);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,57);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,58);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,59);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,60);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (5,61);

-- 6. Bachelor of Science
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,8);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,9);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,11);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,6);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,1);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,38);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,39);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,40);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,41);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,42);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,44);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,46);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,47);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,48);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (6,49);

-- 7. Master of Science
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,8);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,11);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,6);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,1);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,38);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,39);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,40);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,41);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,43);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,44);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,46);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,47);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,49);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (7,57);

-- 8. Bachelor of Business
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,4);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,6);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,13);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,14);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,16);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,17);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,18);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,21);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,25);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,26);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,50);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,52);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,53);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,55);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,56);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,62);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,63);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,64);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (8,66);

-- 9. Master of Business
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,4);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,5);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,6);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,7);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,14);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,16);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,18);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,20);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,21);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,25);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,26);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,38);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,50);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,53);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,54);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,55);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,57);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,58);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,63);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,64);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,65);
INSERT INTO program_elective_courses (program_fk, course_fk) VALUES (9,66);
-- END Program elective courses --------------------



-- Major ------------------------------------------
INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (1, 'BSD', 'Software Development', 1,
'And and jeepers far impulsively scornful sloth frenetically however because within less far masterfully meant while yellow a crud some panda measurable abysmal manta drank festive ravenously one religiously however and that far dove near without cuddled ungracefully in salmon darn ceaseless salacious.',
1);

INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (2, 'MSD', 'Software Development', 1,
'This but boisterous evenly hugged ecstatic one sociable flauntingly much thanks broke manfully jeez misunderstood happily mindful bat this slung impeccably esoterically broad man-of-war near poignantly next.

Vulture rooster gladly much alongside undertook a and by boa less hey goodness unlike lucratively the one a insolent emoted less analytically hey less overran trout cogent or hello and one dwelled mastodon.

More to versus lizard heard kangaroo hello mercifully close far emu deceptively frisky on manatee far elephant guinea and folded jeez brusque squirrel salmon sighed far oh more lorikeet oh emu one cried since concisely less narrowly a earthworm and far tenacious comfortable rebukingly the much hey this seagull on and uncritically hello jeez strange like jeez far.',
2);

INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (3, 'DSD', 'Software Development', 1,
'Hippopotamus irrespective stared ostrich much kept rang sharp well intricate much some innocuously koala unexplainable yikes subtly much far within groundhog approvingly marginally where ostrich much chortled overran due courteously and crud wow rewrote as much quickly snugly babbled flew essentially darn winning pugnaciously tonal up after and after kiwi ostrich while allegedly friskily flabby toward thrust newt.',
3);

INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (4, 'ISM', 'ICT Management', 1,
'More weasel caustically scowled and whimsical much darn abnormally hey spryly that far affecting curtsied packed petted far and yikes then insincere strung some and until rolled the thus jeepers affectingly forbade oh dived much alas alas one jeez including paid regarding the far that humbly so wow a wallaby far worm hey and lugubrious jellyfish far cassowary staunch according much therefore alas.',
5);

INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (5, 'ICA', 'ICT Administration', 1,
'Since tangibly ouch unlocked halfheartedly so the one goodness the some some overlaid up one that vague thanks hello erotically licentious hardheaded beneath bluebird barring thus darn and endless and pushed ignoble this much some much much cheerfully black.

One gibbered fed dear when some fluid far jeepers far less globefish objectively that goldfish well goodness outside wallaby yikes avowedly alas dachshund walking close far some oh affirmative mercifully yikes oh hey ecstatically vexedly jeepers unthinkingly lemming depending some alas and cassowary hawk close hence as one.

Guinea since quail sheared tenacious made this esoterically hello past wore gosh much far spoiled rapt abandonedly much some much concentrically eagerly and one less nonchalantly that wore redid this wow that much a perceptibly cow pulled rooster more overdid auspiciously ungracefully wolf this caterpillar much and tactfully yikes and.

Ducked far impious far across jeez and a crab some enchanting yikes away less cardinal far jeepers far this unjustifiably dragonfly highhanded much growled.',
4);

INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (6, 'BNS', 'Network Security', 1,
'So lizard far well met then jeepers gawked horrendously however much that stubborn jeez that piranha sheep forewent much hey so across lavishly dear and ouch notwithstanding then lobster desperate sniffed constitutionally bet much hello sheep much hello ahead wherever far much this revealed hatchet to excepting wailed far breathless more ambiguous incredible spoiled for goodness woodpecker and timorous far wildebeest for mongoose.',
1);

INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (7, 'MNS', 'Network Security', 1,
'Goodness glaring crab withdrew therefore where macaw eclectic komodo across goodness parrot gauchely watchfully less much dear wow ashamed that and goodness precociously exquisite yikes definitely responsible laughed alas notable and a dachshund bee inescapably wherever bluebird while a reasonable so underlay mandrill barring below far yet stuffy less oh wildebeest disbanded heinously gratefully well piously.',
2);

INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (8, 'MIS', 'Information Security', 1,
'Goodness that overlaid some ripely and the bluebird greyhound that terse against yet indifferent and crud hello extraordinarily gregarious that cantankerously hit in sluggishly diverse and inadvertent folded preparatory more that.

Ahead insect far much or due truthful beaver by concentric foretold much some and on this visceral opposite less and that swelled alas and hatchet sheared as much handsomely bridled forbiddingly one foul inset thin to oh bird yet that remade via jeez cooperatively that monkey red-handedly gaudily and this much promiscuously amid unihibitedly this built much scallop wow until when put up far sober before ostrich wherever.',
5);

INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (9, 'BSC', 'Applied Science', 1,
'Wow hey before kangaroo majestic salmon scurrilous in wetted grunted goodness vainly hello inconsiderately darn insufferably archaic ouch jeepers thankful tenacious hungry less burned allegedly and rancorously exotically much this yet far and along hound lizard imminent grew as forgetful unreceptive hey royally overshot goodness arousing weasel so much including hello petted where.',
6);

INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (10, 'MSC', 'Applied Science', 1,
'Maternal whimsically however darn yikes tangibly tenably and gloated capybara and along jeez heron far so pious fish impertinently impressive extraordinary incoherent far beauteous behind fixed much hello that instead ritual ducked dear much auspicious far salmon smirked evasively some built when and radical circa turtle other much a astonishing worm rigidly alas preparatory some temperately jeepers over hey well jeepers oh crud but faintly ducked yikes aboard lecherous more indecisive one guinea editorially hello more on dolphin during upset much wherever threw avowedly forgave unlike jeepers oh the blubbered conditional hence.',
7);

INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (11, 'BBA', 'Accountancy', 0,
'Flirted far on baboon more perilously on hence far oyster that generously abusively swiftly this the slovene one irritable one tacitly spoiled so sound crud oh weak royal less regal prosperously the one crucial exorbitantly until buffalo and dear this luxuriant some and nudged conditional crookedly as more inaudibly amidst far plankton a but baboon cut roadrunner or shined mastodon more a wow while ahead crud epidemically shined much fitted and below instantaneous amidst after a much inclusive nasty then this after yikes boa the forewent.',
8);

INSERT INTO major (id, code, title, enabled, description, program_fk)
VALUES (12, 'MBA', 'Accountancy', 1,
'Jeez oh haltered alas divisive shuffled and dismounted less after overlay far until aboard exquisitely where whale far a dear despite and much the and ouch anteater bombastically hey much more well along notwithstanding wherever tonally crud fled a darn hello wherever that relentlessly the by dully sluggish close oh after tamely then ground vehement during notwithstanding then black some wow mallard and rebuilt babbled raffish rattlesnake pre-set bald expeditiously far ingenuously stringently patiently treacherous flung quickly a some petted bowed so insane a much globefish toward until vivacious a jeepers fell some more and much falsely overthrew circa.',
9);



-- Major compulsory courses ---------------------------
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (1, 2);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (1, 3);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (1, 5);
-- INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (1, 7);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (1, 21);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (1, 40);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (1, 53);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (2, 2);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (2, 3);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (2, 21);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (2, 35);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (2, 40);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (2, 50);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (3, 2);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (3, 37);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (3, 40);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (4, 5);
-- INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (4, 6);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (4, 19);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (4, 21);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (4, 22);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (4, 50);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (5, 4);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (5, 5);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (5, 7);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (5, 19);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (6, 5);
-- INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (6, 6);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (6, 24);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (6, 29);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (6, 30);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (6, 31);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (6, 40);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (7, 5);
-- INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (7, 6);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (7, 24);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (7, 29);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (7, 45);
-- INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (8, 6);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (8, 7);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (8, 30);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (9, 5);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (9, 10);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (10, 5);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (10, 9);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (10, 10);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (11, 5);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (11, 13);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (11, 14);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (11, 16);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (11, 17);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (11, 21);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (11, 31);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (12, 5);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (12, 14);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (12, 15);
-- INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (12, 19);
INSERT INTO major_compulsory_courses (major_fk, course_fk) VALUES (12, 21);




-- Users ----------------------------------------------
--
-- Admins ---------------------------------------------
-- admin with id = 1 should be inserted in create script
INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (2, 'admin', 'john.smith@jstudyplanner.com', 'jsmith', '12345678', 1, 'John', 'Smith', '987654321', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (3, 'admin', 's.lee@jstudyplanner.com', 's.lee', '12345678', 1, 'Sue', 'Lee', '555577777', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (4, 'admin', 'bob.mc@jstudyplanner.com', 'mcgee', '12345678', 1, 'Bob', 'McGee', '000 999 1234', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (5, 'admin', 's.hong@jstudyplanner.com', 'shong', '12345678', 0, 'Susan', 'Hong', '', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (6, 'admin', 'alex@jstudyplanner.com', 'alex', '12345678', 1, 'Alexander', 'Granovich', '987654321', NULL, NULL, NULL );


-- Staff ----------------------------------------------
INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (7, 'staff', 'sonya@dummy__42_server.info', 'sonya.raymond', '12345678', 1, 'Sonya', 'Raymond', '000111222', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (8, 'staff', 'm.iv@jstudyplanner.com', 'margo', '12345678', 1, 'Margarita', 'Ivashkevich', '995-8841-15', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (9, 'staff', 'Bill@jstudyplanner.com', 'bill.foster', '12345678', 1, 'Bill', 'Foster', '15684971564', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (10, 'staff', 'roy.stivenson@jstudyplanner.com', 'roy.stivenson', '12345678', 1, 'Roy', 'Stivenson', '75278254', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (11, 'staff', 'kevin@jstudyplanner.com', 'Kevin.Sulliwan', '12345678', 1, 'Kevin', 'Sulliwan', 'NA', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (12, 'staff', 'jj86@jstudyplanner.com', 'Jui_Jibao', '12345678', 1, 'Jui', 'Jibao', '13848489', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (13, 'staff', 'garpreeth@jstudyplanner.com', 'Garpreeth.Singh', '12345678', 1, 'Garpreeth', 'Singh', '1123548', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (14, 'staff', 'Lao.Hung@jstudyplanner.com', 'Lao.Hung', '12345678', 0, 'Lao', 'Hung', '', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (15, 'staff', 'rado@jstudyplanner.com', 'radovich.tyzinskiy', '12345678', 1, 'Radovich', 'Tyzinskiy', '559551848', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (16, 'staff', 'mary.safronova@jstudyplanner.com', 'mary.safronova', '12345678', 1, 'Mary', 'Safronova', '+61849813584', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (17, 'staff', 'antony.shwarcz@jstudyplanner.com', 'antony.shwarcz', '12345678', 0, 'Antony', 'Shwarcz', '00365296', NULL, NULL, NULL );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (18, 'staff', 'lence.zoynberg@jstudyplanner.com', 'lence.zoynberg', '12345678', 1, 'Lence', 'Zoynberg', '557 84984 15', NULL, NULL, NULL );


-- Students -------------------------------------------
-- 1.1 Ipswich, BSD	Software Development
INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (19, 'student', 'daniel.smith@jstudyplanner.com', 'daniel.smith', '12345678', 1, 'Daniel', 'Smith', '0489651115', 'domestic', 1, 1 );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (20, 'student', 'ramneet.patel@jstudyplanner.com', 'ramneet.patel', '12345678', 1, 'Ramneet', 'Patel', '045 9848 12', 'international', 1, 1 );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (21, 'student', 'sonya.blake@jstudyplanner.com', 'sonya.blake', '12345678', 1, 'Sonya', 'Blake', '0489651495', 'domestic', 1, 1 );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (22, 'student', 'frida.stone@jstudyplanner.com', 'frida.stone', '12345678', 1, 'Frida', 'Stone', '0489651176', 'domestic', 1, 1 );

INSERT INTO user (id, utype, email, username, password, enabled, first_name, last_name, phone, student_type, major_id, campus_id)
VALUES (23, 'student', 'jeremy.lee@jstudyplanner.com', 'jeremy.lee', '12345678', 0, 'Jeremy', 'Lee', '0489622912', 'international', 1, 1 );




-- Enrollment --------------------------------------
INSERT INTO enrollment (id, ca_fk, user_fk, status) VALUES (1, 1, 19, 'enrolled');
INSERT INTO enrollment (id, ca_fk, user_fk, status) VALUES (2, 4, 19, 'enrolled');
INSERT INTO enrollment (id, ca_fk, user_fk, status) VALUES (3, 10, 19, 'enrolled');
INSERT INTO enrollment (id, ca_fk, user_fk, status) VALUES (4, 11, 19, 'planned');
INSERT INTO enrollment (id, ca_fk, user_fk, status) VALUES (5, 21, 19, 'planned');
INSERT INTO enrollment (id, ca_fk, user_fk, status) VALUES (6, 5, 19, 'planned');
INSERT INTO enrollment (id, ca_fk, user_fk, status) VALUES (7, 29, 19, 'planned');
INSERT INTO enrollment (id, ca_fk, user_fk, status) VALUES (8, 1, 21, 'enrolled');
INSERT INTO enrollment (id, ca_fk, user_fk, status) VALUES (9, 4, 21, 'enrolled');
INSERT INTO enrollment (id, ca_fk, user_fk, status) VALUES (10, 34, 21, 'planned');












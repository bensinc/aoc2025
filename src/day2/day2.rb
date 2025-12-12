
input = File.open("input.txt").read.gsub("\n","")

total = 0

input.split(",").each do |id_range|
	puts "--+ Checking: #{id_range}"
	(id_range.split("-").first.to_i..id_range.split("-").last.to_i).each do |id|
		id = id.to_s
		if id.size % 2 == 0
			puts "  + #{id}: #{id[0..id.size/2-1]} == #{id[id.size/2..-1]}"
			if (id[0..id.size/2-1] == id[id.size/2..-1])
				puts "  + Found: #{id}"
				total += id.to_i 
			end
		end
	end
end

puts "--+ Total: #{total}"
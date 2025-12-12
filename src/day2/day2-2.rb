
input = File.open("input.txt").read.gsub("\n","")

total = 0

def matched?(id)
	id = id.to_s
	(0..id.size).each do |i|
		part = id[0..i]	
		to_check = part
		if id.scan(part).size > 1 && id.size == part.size * id.scan(part).size 
			puts "  + #{id} (#{part}) ADDED"
			return(true)
			
		end
	end
	return(false)
end

input.split(",").each do |id_range|
	puts "--+ Checking: #{id_range}"
	(id_range.split("-").first.to_i..id_range.split("-").last.to_i).each do |id|
		total += id if matched? id
	end
	
end

puts "--+ Total: #{total}"
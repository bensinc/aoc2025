

# def find_joltage(line)
  # joltage = 0
  # sorted = line.each_char.map{|c| c.to_i}.sort
  # puts sorted
  # line.each_char { |c|
 	# joltage += c.to_i 
  # }
  # return joltage
# end


def find_joltage(line, digits)
  joltage = 0
  parts = line.each_char.with_index.map {|c, i| [c, i]}
  sorted_parts = parts.sort_by {|e| e[0]}.reverse
  puts sorted_parts.uniq {|e| e[0]}.to_s
  lowest_parts = sorted_parts.uniq {|e| e[0]}.last(3).reverse
  puts lowest_parts.to_s

  to_remove = []
  lowest_parts.each {|e|
	count = line.each_char.count(e[0])
	puts "#{e[0]}: #{count}"
  }
  
  return joltage
end

total = 0
File.open("input3.txt").each do |line|
  line.chop!
  puts "--+ Starting:     #{line}"
  joltage = find_joltage(line, 2)
  total += joltage
  puts "  + Best joltage: #{joltage}"
  puts "  + Should be:    434234234278\n\n"
end
puts "--+ Total: #{total}"


